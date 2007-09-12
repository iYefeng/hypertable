/**
 * Copyright (C) 2007 Doug Judd (Zvents, Inc.)
 * 
 * This file is part of Hypertable.
 * 
 * Hypertable is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 * 
 * Hypertable is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

#include <cstdlib>
#include <iostream>
#include <string>

extern "C" {
#include <sys/types.h>
#include <unistd.h>
}

#include "Common/FileUtils.h"
#include "Common/Logger.h"
#include "Common/System.h"

using namespace hypertable;
using namespace std;

int main(int argc, char **argv) {
  std::string commandStr;

  System::Initialize(argv[0]);

  if (!FileUtils::Exists("./rsclient")) {
    LOG_ERROR("Unable to find ./rsclient");
    return 1;
  }

  if (!FileUtils::Exists("./hypertable.cfg")) {
    LOG_ERROR("Unable to find ./hypertable.cfg");
    return 1;
  }

  if (!FileUtils::Exists("./testdata.txt")) {
    LOG_ERROR("Unable to find ./testdata.txt");
    return 1;
  }

  if (!FileUtils::Exists("./Test1.cmd")) {
    LOG_ERROR("Unable to find ./Test1.cmd");
    return 1;
  }

  commandStr = (std::string)"./rsclient --config=hypertable.cfg < Test1.cmd > rsTest.output";
  if (system(commandStr.c_str()) != 0)
    return 1;

  commandStr = (std::string)"diff rsTest.output rsTest.golden";
  if (system(commandStr.c_str()) != 0)
    return 1;

  if (!FileUtils::Exists("./Test2-data.txt")) {
    LOG_ERROR("Unable to find ./Test2-data.txt");
    return 1;
  }

  if (!FileUtils::Exists("./Test2.cmd")) {
    LOG_ERROR("Unable to find ./Test2.cmd");
    return 1;
  }

  commandStr = (std::string)"./rsclient --config=hypertable.cfg < Test2.cmd > Test2.output";
  if (system(commandStr.c_str()) != 0)
    return 1;

  commandStr = (std::string)"diff Test2.output Test2.golden";
  if (system(commandStr.c_str()) != 0)
    return 1;


  return 0;
}

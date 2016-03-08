/** -*- c++ -*-
 * Copyright (C) 2007-2016 Hypertable, Inc.
 *
 * This file is part of Hypertable.
 *
 * Hypertable is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 3 of the
 * License, or any later version.
 *
 * Hypertable is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

#include "Common/Compat.h"
#include "Common/Init.h"

#include "AsyncComm/Config.h"

#include <iostream>

using namespace Hypertable;
using namespace Config;
using namespace std;

namespace {

  String lookup_property;

  const char *usage =
    "\n"
    "Usage: get_property [options] <property>\n\nOptions"
    ;

  struct AppPolicy : Policy {
    static void init_options() {
      cmdline_desc(usage);
      cmdline_hidden_desc().add_options()("property", str(), "");
      cmdline_positional_desc().add("property", -1);
    }
    static void init() {
      if (has("property"))
        lookup_property = get_str("property");
    }
  };

  typedef Cons<AppPolicy, DefaultCommPolicy> Policies;

} // local namespace

#define TRY(exp, t)        \
    try { cout << exp; goto bail; } catch (Exception &e) { if (t) throw e; }

int main(int argc, char **argv)
{
  try {
    init_with_policy<Policies>(argc, argv);
    if (properties->has(lookup_property)) {
      // issue 869: in order to avoid type conversion errors we have to try
      // all available conversion functions
      TRY(properties->get_str(lookup_property), false)
      TRY(properties->get_bool(lookup_property), false)
      TRY(properties->get_i16(lookup_property), false)
      TRY(properties->get_i32(lookup_property), false)
      TRY(properties->get_i64(lookup_property), false)
      TRY(properties->get_f64(lookup_property), true)
    }
    else {
      cout << lookup_property << "-PROPERTY-DOES-NOT-EXIST";
    }
  }
  catch (Exception &e) {
    HT_ERROR_OUT << e << HT_END;
  }

bail:
  cout << flush;
  quick_exit(EXIT_SUCCESS);
}

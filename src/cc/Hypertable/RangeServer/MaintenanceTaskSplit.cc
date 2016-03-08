/*
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

#include <Common/Compat.h>

#include "MaintenanceTaskSplit.h"

using namespace Hypertable;
using namespace std;

MaintenanceTaskSplit::MaintenanceTaskSplit(uint32_t level, int priority,
                                           chrono::time_point<chrono::steady_clock> &stime,
                                           RangePtr &range)
  : MaintenanceTask(level, priority, stime, range, String("SPLIT ") + range->get_name()) {
  set_retry_delay(5000);
  set_retry(true);
}

void MaintenanceTaskSplit::execute() {
  m_range->split();
}

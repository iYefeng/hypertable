/*
 * Copyright (C) 2007-2015 Hypertable, Inc.
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

/** @file
 * Declarations for RangeServerClient.
 * This file contains declarations for RangeServerClient, a client interface class
 * to the RangeServer.
 */

#ifndef Hypertable_Lib_RangeServer_Client_h
#define Hypertable_Lib_RangeServer_Client_h

#include <Common/InetAddr.h>
#include <Common/StaticBuffer.h>
#include <Common/Status.h>

#include <AsyncComm/Comm.h>
#include <AsyncComm/CommBuf.h>
#include <AsyncComm/DispatchHandler.h>

#include <Hypertable/Lib/QualifiedRangeSpec.h>
#include <Hypertable/Lib/RangeServerRecovery/ReceiverPlan.h>
#include <Hypertable/Lib/RangeSpec.h>
#include <Hypertable/Lib/RangeState.h>
#include <Hypertable/Lib/ScanBlock.h>
#include <Hypertable/Lib/ScanSpec.h>
#include <Hypertable/Lib/StatsRangeServer.h>
#include <Hypertable/Lib/SystemVariable.h>
#include <Hypertable/Lib/TableIdentifier.h>

#include <map>
#include <memory>

namespace Hypertable {
namespace Lib {
namespace RangeServer {

  /// @addtogroup libHypertableRangeServer
  /// @{

  /** %Client interface to RangeServer.
   * This class provides a client interface to the RangeServer.  It has methods,
   * both synchronous and asynchronous, that carry out %RangeServer operations.
   */
  class Client {
  public:

    Client(Comm *comm, int32_t timeout_ms=0);
    ~Client();

    /** Sets the default client connection timeout.
     * @param timeout_ms timeout value in milliseconds
     */
    void set_default_timeout(int32_t timeout_ms) {
      m_default_timeout_ms = timeout_ms;
    }
    int32_t default_timeout() const { return m_default_timeout_ms; }

    /** Issues a "compact" request synchronously.
     * @param addr address of RangeServer
     * @param table %Table identifier of table to compact
     * @param row Row containing range to compact
     * @param flags Compaction flags
     *        (see RangeServerProtocol::CompactionFlags)
     */
    void compact(const CommAddress &addr, const TableIdentifier &table,
                 const String &row, int32_t flags);

    /** Issues a "compact" request asynchronously.
     * @param addr address of RangeServer
     * @param table %Table identifier of table to compact
     * @param row Row containing range to compact
     * @param flags Compaction flags
     *        (see RangeServerProtocol::CompactionFlags)
     * @param handler Dispatch handler
     */
    void compact(const CommAddress &addr, const TableIdentifier &table,
                 const String &row, int32_t flags, DispatchHandler *handler);

    /** Issues a "compact" request asynchronously with a timer.
     * @param addr address of RangeServer
     * @param table %Table identifier of table to compact
     * @param row Row containing range to compact
     * @param flags Compaction flags
     *        (see RangeServerProtocol::CompactionFlags)
     * @param handler dispatch handler
     * @param timer Deadline timer
     */
    void compact(const CommAddress &addr, const TableIdentifier &table,
                 const String &row, int32_t flags,
                 DispatchHandler *handler, Timer &timer);

    /** Issues a synchronous "load range" request.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param range_spec range specification
     * @param range_state range state
     * @param needs_compaction if true range needs compaction after load
     */
    void load_range(const CommAddress &addr, const TableIdentifier &table,
                    const RangeSpec &range_spec, const RangeState &range_state,
                    bool needs_compaction);

    /** Issues a synchronous "load range" request with timer.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param range_spec range specification
     * @param range_state range state
     * @param needs_compaction if true range needs compaction after load
     * @param timer timer
     */
    void load_range(const CommAddress &addr, const TableIdentifier &table,
                    const RangeSpec &range_spec,  const RangeState &range_state,
                    bool needs_compaction, Timer &timer);

    /** Issues a synchronous "acknowledge load" request for multiple ranges.
     * @param addr address of RangeServer
     * @param ranges qualified range spec
     * @param response_map per range responses to acknowledge_load
     */
    void acknowledge_load(const CommAddress &addr,
                          const vector<QualifiedRangeSpec *> &ranges,
                          std::map<QualifiedRangeSpec, int> &response_map);

    /** Issues an "update" request asynchronously.  The data argument holds a
     * sequence of key/value pairs.  Each key/value pair is encoded as two
     * variable lenght ByteString records back-to-back.  This method takes
     * ownership of the data buffer.
     * @param addr address of RangeServer
     * @param cluster_id Originating cluster ID
     * @param table table identifier
     * @param count number of key/value pairs in buffer
     * @param buffer buffer holding key/value pairs
     * @param flags update flags
     * @param handler response handler
     */
    void update(const CommAddress &addr, uint64_t cluster_id,
                const TableIdentifier &table, int32_t count,
                StaticBuffer &buffer, int32_t flags,
                DispatchHandler *handler);

    /** Issues a "create scanner" request asynchronously.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param range range specification
     * @param scan_spec scan specification
     * @param handler response handler
     */
    void create_scanner(const CommAddress &addr, const TableIdentifier &table,
                        const RangeSpec &range, const ScanSpec &scan_spec,
                        DispatchHandler *handler);

    /** Issues a "create scanner" request asynchronously with timer.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param range range specification
     * @param scan_spec scan specification
     * @param handler response handler
     * @param timer timer
     */
    void create_scanner(const CommAddress &addr, const TableIdentifier &table,
                        const RangeSpec &range, const ScanSpec &scan_spec,
                        DispatchHandler *handler, Timer &timer);

    /** Issues a "create scanner" request.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param range range specification
     * @param scan_spec scan specification
     * @param scan_block block of return key/value pairs
     */
    void create_scanner(const CommAddress &addr, const TableIdentifier &table,
                        const RangeSpec &range, const ScanSpec &scan_spec,
                        ScanBlock &scan_block);

    /** Issues a synchronous "create scanner" request with timer.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param range range specification
     * @param scan_spec scan specification
     * @param scan_block block of return key/value pairs
     * @param timer timer
     */
    void create_scanner(const CommAddress &addr, const TableIdentifier &table,
                        const RangeSpec &range, const ScanSpec &scan_spec,
                        ScanBlock &scan_block, Timer &timer);

    /** Issues a "destroy scanner" request asynchronously.
     * @param addr address of RangeServer
     * @param scanner_id Scanner ID returned from a call to create_scanner.
     * @param handler response handler
     */
    void destroy_scanner(const CommAddress &addr, int32_t scanner_id,
                         DispatchHandler *handler);

    /** Issues a "destroy scanner" request asynchronously with timer.
     * @param addr address of RangeServer
     * @param scanner_id Scanner ID returned from a call to create_scanner.
     * @param handler response handler
     * @param timer timer
     */
    void destroy_scanner(const CommAddress &addr, int32_t scanner_id,
                         DispatchHandler *handler, Timer &timer);

    /** Issues a synchronous "destroy scanner" request.
     * @param addr address of RangeServer
     * @param scanner_id scanner ID returned from a call to create_scanner.
     */
    void destroy_scanner(const CommAddress &addr, int32_t scanner_id);

    /** Issues a synchronous "destroy scanner" request with timer.
     * @param addr address of RangeServer
     * @param scanner_id scanner ID returned from a call to create_scanner.
     * @param timer timer
     */
    void destroy_scanner(const CommAddress &addr, int32_t scanner_id, Timer &timer);

    /** Issues a "fetch scanblock" request asynchronously.
     * @param addr address of RangeServer
     * @param scanner_id Scanner ID returned from a call to create_scanner.
     * @param handler response handler
     */
    void fetch_scanblock(const CommAddress &addr, int32_t scanner_id,
                         DispatchHandler *handler);

    /** Issues a "fetch scanblock" request asynchronously.
     * @param addr address of RangeServer
     * @param scanner_id Scanner ID returned from a call to create_scanner.
     * @param handler response handler
     * @param timer timer
     */
    void fetch_scanblock(const CommAddress &addr, int32_t scanner_id,
                         DispatchHandler *handler, Timer &timer);

    /** Issues a synchronous "fetch scanblock" request.
     * @param addr address of RangeServer
     * @param scanner_id scanner ID returned from a call to create_scanner.
     * @param scan_block block of return key/value pairs
     */
    void fetch_scanblock(const CommAddress &addr, int32_t scanner_id,
                         ScanBlock &scan_block);

    /** Issues a synchronous "fetch scanblock" request with timer.
     * @param addr address of RangeServer
     * @param scanner_id scanner ID returned from a call to create_scanner.
     * @param scan_block block of return key/value pairs
     * @param timer timer
     */
    void fetch_scanblock(const CommAddress &addr, int32_t scanner_id,
                         ScanBlock &scan_block, Timer &timer);

    /** Issues a "drop table" request asynchronously.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param handler response handler
     */
    void drop_table(const CommAddress &addr, const TableIdentifier &table,
                    DispatchHandler *handler);

    /** Issues a "drop table" request asynchronously with timer.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param handler response handler
     * @param timer timer
     */
    void drop_table(const CommAddress &addr, const TableIdentifier &table,
                    DispatchHandler *handler, Timer &timer);

    /** Issues a synchronous "drop table" request.
     * @param addr address of RangeServer
     * @param table table identifier
     */
    void drop_table(const CommAddress &addr, const TableIdentifier &table);

    /** Issues a synchronous "drop table" request with timer.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param timer timer
     */
    void drop_table(const CommAddress &addr,
                    const TableIdentifier &table,
                    Timer &timer);

    /** Issues a "update schema" request asynchronously.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param schema the new schema for this table
     * @param handler response handler
     */
    void update_schema(const CommAddress &addr,
        const TableIdentifier &table, const String &schema,
        DispatchHandler *handler);

    /** Issues a "update schema" request asynchronously with timer.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param schema the new schema for this table
     * @param handler response handler
     * @param timer timer
     */
    void update_schema(const CommAddress &addr,
                       const TableIdentifier &table, const String &schema,
                       DispatchHandler *handler, Timer &timer);

    /** Issues a "commit_log_sync" request asynchronously.
     * @param addr address of RangeServer
     * @param cluster_id Originating cluster ID
     * @param table Table for which commit log sync is needed
     * @param handler response handler
     */
    void commit_log_sync(const CommAddress &addr, uint64_t cluster_id,
                         const TableIdentifier &table,
                         DispatchHandler *handler);

    /** Issues a "commit_log_sync" request asynchronously with timer.
     * @param addr address of RangeServer
     * @param cluster_id Originating cluster ID
     * @param table Table for which commit log sync is needed
     * @param handler response handler
     * @param timer timer
     */
    void commit_log_sync(const CommAddress &addr, uint64_t cluster_id,
                         const TableIdentifier &table,
                         DispatchHandler *handler, Timer &timer);

    /** Issues a "status" request.  This call blocks until it receives a
     * response from the server.
     * @param addr address of RangeServer
     * @param status Output variable to hold status
     */
    void status(const CommAddress &addr, Status &status);

    /** Issues a "status" request with timer.  This call blocks until it
     * receives a response from the server.
     * @param addr address of RangeServer
     * @param status Output variable to hold status
     * @param timer timer
     */
    void status(const CommAddress &addr, Status &status, Timer &timer);

    /// Issues an asynchonous <i>status</i> request with timer.
    /// @param addr Address of RangeServer
    /// @param handler Response handler
    /// @param timer Deadline timer
    void status(const CommAddress &addr, DispatchHandler *handler,
                Timer &timer);

    /** Issues a "wait_for_maintenance" request.  This call blocks until it receives a
     * response from the server or times out.
     * @param addr address of RangeServer
     */
    void wait_for_maintenance(const CommAddress &addr);

    /** Issues a "shutdown" request.  This call blocks until it receives a
     * response from the server or times out.
     * @param addr address of RangeServer
     */
    void shutdown(const CommAddress &addr);

    void dump(const CommAddress &addr, String &outfile, bool nokeys);

    /** @deprecated
     */
    void dump_pseudo_table(const CommAddress &addr, const TableIdentifier &table,
                           const String &pseudo_table_name, const String &outfile);

    /** Issues an synchronous "get_statistics" request.
     * @param addr address of RangeServer
     * @param specs Vector of system state variable specs
     * @param generation System state generation
     * @param stats reference to RangeServer stats object
     */
    void get_statistics(const CommAddress &addr, std::vector<SystemVariable::Spec> &specs,
                        int64_t generation, StatsRangeServer &stats);

    /** Issues an synchronous "get_statistics" request with timer.
     * @param addr address of RangeServer
     * @param specs Vector of system state variable specs
     * @param generation System state generation
     * @param stats reference to RangeServer stats object
     * @param timer timer
     */
    void get_statistics(const CommAddress &addr, std::vector<SystemVariable::Spec> &specs,
                        int64_t generation, StatsRangeServer &stats, Timer &timer);

    /** Issues an asynchronous "get_statistics" request.
     * @param addr address of RangeServer
     * @param specs Vector of system state variable specs
     * @param generation System state generation
     * @param handler Dispatch handler for asynchronous callback
     */
    void get_statistics(const CommAddress &addr, std::vector<SystemVariable::Spec> &specs,
                        int64_t generation, DispatchHandler *handler);


    /** Issues an asynchronous "get_statistics" request with timer.
     * @param addr Address of RangeServer
     * @param specs Vector of system state variable specs
     * @param generation System state generation
     * @param handler Dispatch handler for asynchronous callback
     * @param timer Maximum wait timer
     */
    void get_statistics(const CommAddress &addr, std::vector<SystemVariable::Spec> &specs,
                        int64_t generation, DispatchHandler *handler, Timer &timer);

    /** Issues an asynchronous "drop range" request asynchronously.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param range range specification
     * @param handler response handler
     */
    void drop_range(const CommAddress &addr, const TableIdentifier &table,
                    const RangeSpec &range, DispatchHandler *handler);

    /** Issues an asynchronous "drop range" request asynchronously with timer.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param range range specification
     * @param handler response handler
     * @param timer timer
     */
    void drop_range(const CommAddress &addr, const TableIdentifier &table,
                    const RangeSpec &range, DispatchHandler *handler,
                    Timer &timer);

    /** Issues a "relinquish range" request synchronously.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param range range specification
     */
    void relinquish_range(const CommAddress &addr, const TableIdentifier &table,
                          const RangeSpec &range);

    /** Issues a "relinquish range" request synchronously, with timer.
     * @param addr address of RangeServer
     * @param table table identifier
     * @param range range specification
     * @param timer timer
     */
    void relinquish_range(const CommAddress &addr, const TableIdentifier &table,
                          const RangeSpec &range, Timer &timer);

    /** Issues a "heapcheck" request.  This call blocks until it receives a
     * response from the server.
     * @param addr address of RangeServer
     * @param outfile output file to dump heap stats to
     */
    void heapcheck(const CommAddress &addr, String &outfile);

    /** Issues a synchronous "replay_fragments" request.
     * @param addr Address of RangeServer
     * @param op_id ID of the calling recovery operation
     * @param recover_location Location of the server being recovered
     * @param plan_generation Recovery plan generation
     * @param type Type of fragments to play
     * @param fragments Fragments being requested for replay
     * @param plan Recovery receiver plan
     * @param replay_timeout timeout for replay to finish
     */
    void replay_fragments(const CommAddress &addr, int64_t op_id,
                          const String &recover_location, int32_t plan_generation,
                          int32_t type, const vector<int32_t> &fragments,
                          const Lib::RangeServerRecovery::ReceiverPlan &plan,
                          int32_t replay_timeout);

    /** Issues a "phantom_load" synchronous request.
     * @param addr address of RangeServer
     * @param location location of server being recovered
     * @param plan_generation recovery plan generation
     * @param fragments fragments being replayed
     * @param range_specs range specs to be loaded
     * @param range_states parallel range states array
     */
    void phantom_load(const CommAddress &addr, const String &location,
                      int32_t plan_generation,
                      const vector<int32_t> &fragments,
                      const vector<QualifiedRangeSpec> &range_specs,
                      const vector<RangeState> &range_states);

    /** Issues a "phantom_update" asynchronous request.
     * @param addr address of RangeServer
     * @param location location being recovered
     * @param plan_generation recovery plan generation
     * @param range Qualfied range specification
     * @param fragment Fragment ID
     * @param updates Buffer of updates
     * @param handler Dispatch handler
     */
    void phantom_update(const CommAddress &addr, const String &location,
                        int32_t plan_generation, const QualifiedRangeSpec &range,
                        int32_t fragment, StaticBuffer &updates,
                        DispatchHandler *handler);

    /** Issues a "phantom_prepare_ranges" synchronous request.
     * @param addr address of RangeServer
     * @param op_id ID of Master recovery operation 
     * @param location location of server being recovered
     * @param plan_generation recovery plan generation
     * @param ranges range specs to be prepared
     * @param timeout timeout
     */
    void phantom_prepare_ranges(const CommAddress &addr, int64_t op_id,
                                const String &location, int32_t plan_generation,
                                const vector<QualifiedRangeSpec> &ranges,
                                int32_t timeout);

    /** Issues a "phantom_commit_ranges" synchronous request.
     * @param addr address of RangeServer
     * @param op_id ID of Master recovery operation 
     * @param location location of server being recovered
     * @param plan_generation recovery plan generation
     * @param ranges range specs to be committed
     * @param timeout timeout
     */
    void phantom_commit_ranges(const CommAddress &addr, int64_t op_id,
                               const String &location, int32_t plan_generation,
                               const vector<QualifiedRangeSpec> &ranges,
                               int32_t timeout);

    /** Issues an asynchronous "set_state" request with timer.
     * @param addr Address of RangeServer
     * @param specs Vector of system state variable specs
     * @param generation System state generation
     * @param handler Dispatch handler for asynchronous callback
     * @param timer Maximum wait timer
     */
    void set_state(const CommAddress &addr, std::vector<SystemVariable::Spec> &specs,
                   int64_t generation, DispatchHandler *handler, Timer &timer);

    /// Issues an asynchronous RangeServer::table_maintenance_enable().
    /// @param addr Address of RangeServer
    /// @param table %Table identifier
    /// @param handler Dispatch handler for asynchronous callback
    void table_maintenance_enable(const CommAddress &addr,
                                  const TableIdentifier &table,
                                  DispatchHandler *handler);

    /// Issues an asynchronous RangeServer::table_maintenance_disable() request.
    /// @param addr Address of RangeServer
    /// @param table %Table identifier
    /// @param handler Dispatch handler for asynchronous callback
    void table_maintenance_disable(const CommAddress &addr,
                                   const TableIdentifier &table,
                                   DispatchHandler *handler);

  private:
    void do_load_range(const CommAddress &addr, const TableIdentifier &table,
                       const RangeSpec &range_spec, const RangeState &range_state,
		       bool needs_compaction, int32_t timeout_ms);
    void do_create_scanner(const CommAddress &addr,
                           const TableIdentifier &table, const RangeSpec &range,
                           const ScanSpec &scan_spec, ScanBlock &scan_block,
                           int32_t timeout_ms);
    void do_destroy_scanner(const CommAddress &addr, int32_t scanner_id,
                            int32_t timeout_ms);
    void do_fetch_scanblock(const CommAddress &addr, int32_t scanner_id,
                            ScanBlock &scan_block, int32_t timeout_ms);
    void do_drop_table(const CommAddress &addr,
                       const TableIdentifier &table,
                       int32_t timeout_ms);
    void do_status(const CommAddress &addr, Status &status, int32_t timeout_ms);
    void do_get_statistics(const CommAddress &addr, std::vector<SystemVariable::Spec> &specs,
                           int64_t generation, StatsRangeServer &stats,
                           int32_t timeout_ms);
    void do_relinquish_range(const CommAddress &addr, const TableIdentifier &table,
                             const RangeSpec &range, int32_t timeout_ms);

    void send_message(const CommAddress &addr, CommBufPtr &cbp,
                      DispatchHandler *handler, int32_t timeout_ms);

    Comm *m_comm;
    int32_t m_default_timeout_ms;
  };

  /// Smart pointer to Client
  typedef std::shared_ptr<Client> ClientPtr;

  /// @}

}}}

#endif // Hypertable_Lib_RangeServer_Client_h
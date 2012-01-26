/*
 * Portions of this file Copyright 1999-2005 University of Chicago
 * Portions of this file Copyright 1999-2005 The University of Southern California.
 *
 * This file or a portion of this file is licensed under the
 * terms of the Globus Toolkit Public License, found at
 * http://www.globus.org/toolkit/download/license.html.
 * If you redistribute this file, with or without
 * modifications, you must include this notice in the file.
 */
package org.globus.gram.internal;

public interface GRAMProtocolErrorConstants {

    public static final int 
	PARAMETER_NOT_SUPPORTED = 1,
	INALID_REQUEST = 2,
	NO_RESOURCES = 3,
        BAD_DIRECTORY = 4,
        EXECUTABLE_NOT_FOUND = 5,
	INSUFFICIENT_FUNDS = 6,
	ERROR_AUTHORIZATION = 7,
	USER_CANCELLED = 8,
	SYSTEM_CANCELLED = 9,
	PROTOCOL_FAILED = 10, ERROR_PROTOCOL_FAILED = 10,
        STDIN_NOT_FOUND = 11,
	CONNECTION_FAILED = 12, ERROR_CONNECTION_FAILED = 12,
        INVALID_MAXTIME = 13,
        INVALID_COUNT = 14,
	NULL_SPECIFICATION_TREE = 15,
        JM_FAILED_ALLOW_ATTACH = 16,
	JOB_EXECUTION_FAILED = 17,
	INVALID_PARADYN = 18,
        INVALID_JOBTYPE = 19,
	INVALID_MYJOB = 20,
	BAD_SCRIPT_ARG_FILE = 21,
	ARG_FILE_CREATION_FAILED = 22,
	INVALID_JOBSTATUS = 23,
	INVALID_SCRIPT_REPLY = 24,
	INVALID_SCRIPT_STATUS = 25,
	MPI_NOT_SUPPORTED = 26,
	UNIMPLEMENTED = 27,
	TEMP_SCRIPT_FILE_FAILED = 28,
        USER_PROXY_NOT_FOUND = 29,
	PROXY_FILE_OPEN_FAILED = 30,
	JOB_CANCEL_FAILED = 31,
	MALLOC_FAILED = 32,
	DUCT_INIT_FAILED = 33,
	DUCT_LSP_FAILED = 34,
        INVALID_HOST_COUNT = 35,
	UNSUPPORTED_PARAMETER = 36,
	INVALID_QUEUE = 37,
	INVALID_PROJECT = 38,
        RSL_EVALUATION_FAILED = 39,
	BAD_RSL_ENVIRONMENT = 40,
	DRYRUN = 41,
	ZERO_LENGTH_RSL = 42,
        ERROR_STAGING_EXECUTABLE = 43,
        ERROR_STAGING_STDIN = 44,
	INVALID_JOB_MANAGER_TYPE = 45,
	BAD_ARGUMENTS = 46,
	GATEKEEPER_MISCONFIGURED = 47,
        BAD_RSL = 48,
	VERSION_MISMATCH = 49,
	RSL_ARGUMENTS = 50,
	RSL_COUNT = 51,
	RSL_DIRECTORY = 52,
	RSL_DRYRUN = 53,
	RSL_ENVIRONMENT = 54,
	RSL_EXECUTABLE = 55,
	RSL_HOST_COUNT = 56,
	RSL_JOBTYPE = 57,
	RSL_MAXTIME = 58,
	RSL_MYJOB = 59,
	ERROR_RSL_PARADYN = 60,
	ERROR_RSL_PROJECT = 61,
	ERROR_RSL_QUEUE = 62,
	ERROR_RSL_STDERR = 63,
	ERROR_RSL_STDIN = 64,
	ERROR_RSL_STDOUT = 65,
	ERROR_OPENING_JOBMANAGER_SCRIPT = 66,
	ERROR_CREATING_PIPE = 67,
	ERROR_FCNTL_FAILED = 68,
	ERROR_STDOUT_FILENAME_FAILED = 69,
	ERROR_STDERR_FILENAME_FAILED = 70,
        ERROR_FORKING_EXECUTABLE = 71,
	EXECUTABLE_PERMISSIONS = 72,
        ERROR_OPENING_STDOUT = 73,
        ERROR_OPENING_STDERR = 74,
        ERROR_OPENING_CACHE_USER_PROXY = 75,
	ERROR_OPENING_CACHE = 76,
        ERROR_INSERTING_CLIENT_CONTACT = 77,
        CLIENT_CONTACT_NOT_FOUND = 78,
	ERROR_CONTACTING_JOB_MANAGER = 79,
	INVALID_JOB_CONTACT = 80,
	EXECUTABLE_UNDEFINED = 81,
        INVALID_MIN_MEMORY = 86,
        INVALID_MAX_MEMORY = 87,
	HTTP_UNFRAME_FAILED      = 89,
	HTTP_UNPACK_FAILED = 91,
	INVALID_JOB_QUERY = 92,
	ERROR_SERVICE_NOT_FOUND  = 93,
	JOB_QUERY_DENIAL         = 94,
	CALLBACK_NOT_FOUND       = 95,
	BAD_GATEKEEPER_CONTACT   = 96,
        INVALID_MAX_WALL_TIME = 102,
	INVALID_MAX_CPU_TIME = 104,
	ERROR_SIGNALING_JOB = 107,
	UNKNOWN_SIGNAL_TYPE = 108,
	WAITING_FOR_COMMIT = 110,
	COMMIT_TIMED_OUT = 111;

}

package com.asadkhan.codebillion.code.editor.data;

import com.asadkhan.codebillion.code.editor.base.models.CompileRequestDO;
import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;
import com.asadkhan.codebillion.code.editor.base.models.TokenDO;
import com.asadkhan.codebillion.code.editor.base.presenters.DataRepository;
import com.asadkhan.network.interactors.NetworkService;
import com.asadkhan.threading.threadhandlers.ThreadHandler;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;

public class CompilerDataRepository extends DataRepository implements CompilerRepository {

    @Inject
    public CompilerDataRepository(
            NetworkService network, ThreadHandler threadHandler) {
        super(network, threadHandler);
    }

    @Override
    public Observable<Response<TokenDO>> compile(String sourceCode, int languageId) {
        String path = "/submissions/";
        CompileRequestDO request = createRequest(sourceCode, languageId);
        return networkService
                .post(TokenDO.class, path, request)
                .compose(schedule());
    }

    @Override
    public Observable<TokenDO> execute(String sourceCode, int languageId) {
        String path = "/submissions/";
        CompileRequestDO request = createRequest(sourceCode, languageId);
        return networkService
                .post(TokenDO.class, path, request)
                .compose(schedule())
                .map(Response::body);
    }

    @Override
    public Observable<Response<TokenDO>> compile(CompileRequestDO request) {
        String path = "submissions";
        return networkService
                .post(TokenDO.class, path, request)
                .compose(schedule());
    }

    @Override
    public Observable<TokenDO> execute(CompileRequestDO request) {
        String path = "/submissions/";
        return networkService
                .post(TokenDO.class, path, request)
                .compose(schedule())
                .map(Response::body);
    }

    @Override
    public Observable<Response<CompileResultDO>> fetchResults(String token) {
        String path = String.format("submissions/%s/", token);
        return networkService
                .getWithQueries(CompileResultDO.class, path, getFieldsMap())
                .compose(schedule());
    }

    @Override
    public Observable<Response<CompileResultDO>> compileAsync(CompileRequestDO requestDO) {
        String path = "/submissions/";
        HashMap<String, String> queryMap = getFieldsMap();
        queryMap.put("wait", "true");
        return networkService
                .getWithQueries(CompileResultDO.class, path, queryMap)
                .compose(schedule());
    }

    public static CompileRequestDO createRequest(String sourceCode, int languageId) {
        return new CompileRequestDO(sourceCode, languageId);
    }

    public HashMap<String, String> getFieldsMap() {
        String fields = "source_code,language_id,stdin,expected_output,cpu_time_limit,cpu_extra_time,wall_time_limit,memory_limit,stack_limit,max_processes_and_or_threads,enable_per_process_and_thread_time_limit,enable_per_process_and_thread_memory_limit,max_file_size,number_of_runs,stdout,stderr,compile_output,message,exit_code,exit_signal,status,created_at,finished_at,token,time,wall_time,memory";
        HashMap<String, String> map = new HashMap<>();
        map.put("fields", fields);
        return map;
    }
}

/**
 *  API documentation Reference
 * =============================
 *
 *  Link : https://api.judge0.com/#top
 *
 * */

// #	Name	                                     Type	   Unit	        Description	                        Default Value
// #    ######################################################################################################################################################

// 1	source_code	                                 text		            Program’s source code.	No default. This attribute is required.
// 2	language_id	                                 integer		        Language ID.	No default. This attribute is required
// 3	stdin	                                     text		            Input for program.	null. Program won’t receive anything to standard input.
// 4	expected_output	                             text		            Expected output of program. Used when you want to compare with stdout.	null. Program’s stdout won’t be compared with expected_output.
// 5	cpu_time_limit	                             float	    second	    Default runtime limit for every program. Time in which the OS assigns the processor to different tasks is not counted.	Depends on configuration.
// 6	cpu_extra_time	                             float	    second	    When a time limit is exceeded, wait for extra time, before killing the program. This has the advantage that the real execution time is reported, even though it slightly exceeds the limit.	Depends on configuration.
// 7	wall_time_limit	                             float	    second	    Limit wall-clock time in seconds. Decimal numbers are allowed. This clock measures the time from the start of the program to its exit, so it does not stop when the program has lost the CPU or when it is waiting for an external event. We recommend to use cpu_time_limit as the main limit, but set wall_time_limit to a much higher value as a precaution against sleeping programs.	Depends on configuration.
// 8	memory_limit	                             float	    second	    Limit address space of the program.	Depends on configuration.
// 9	stack_limit	                                 integer	kilobyte    Limit process stack.	Depends on configuration.
// 10	max_processes_and_or_threads	             integer		        Maximum number of processes and/or threads program can create.	Depends on configuration.
// 11	enable_per_process_and_thread_time_limit	 boolean		        If true then cpu_time_limit will be used as per process and thread.	Depends on configuration.
// 12	enable_per_process_and_thread_memory_limit	 boolean		        If true then memory_limit will be used as per process and thread.	Depends on configuration.
// 13	max_file_size	                             integer	kilobyte    Limit file size created or modified by the program.	Depends on configuration.
// 14	number_of_runs	                             integer		        Run each program number_of_runs times and take average of time and memory.	Depends on configuration.

// 15	stdout	                                     text		            Standard output of the program after execution.
// 16	stderr	                                     text		            Standard error of the program after execution.
// 17	compile_output	                             text		            Compiler output after compilation.
// 18	message	                                     text		            Sandbox’s message. Can contain error messages.
// 19	exit_code	                                 integer		        The program’s exit code.
// 20	exit_signal	                                 integer		        Signal code that the program recieved before exiting.
// 21	status	                                        		            Submission status.
// 22	created_at	                                 datetime		        Date and time when submission was created.
// 23	finished_at	                                 datetime		        Date and time when submission was processed.	null if submission is still in queue or if submission is processing.
// 24	token	                                     string		            Unique submission token used for getting specific submission.
// 25	time	                                     float	    second	    Program’s runtime.
// 26	wall_time	                                 float	    second	    Program’s wall time. Should be greater or equal to time.
// 27	memory	                                     float	    kilobyte    Memory used by the program after execution.

interface ApiReference {

}


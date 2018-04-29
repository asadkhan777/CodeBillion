
package com.asadkhan.codebillion.code.editor.base.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.concurrent.ConcurrentHashMap;

public class CompileRequestDO {

    public CompileRequestDO() {
    }

    public CompileRequestDO(String sourceCode, Integer languageId) {
        // The only 2 required fields
        this.sourceCode = sourceCode;
        this.languageId = languageId;
    }

    @SerializedName("source_code")
    @Expose
    public String sourceCode;

    @SerializedName("language_id")
    @Expose
    public Integer languageId;

    @SerializedName("stdin")
    @Expose
    public String stdin;

    @SerializedName("expected_output")
    @Expose
    public String expectedOutput;

    @SerializedName("cpu_time_limit")
    @Expose
    public Double cpuTimeLimit;

    @SerializedName("cpu_extra_time")
    @Expose
    public Double cpuExtraTime;

    @SerializedName("wall_time_limit")
    @Expose
    public Double wallTimeLimit;

    @SerializedName("memory_limit")
    @Expose
    public Integer memoryLimit;

    @SerializedName("stack_limit")
    @Expose
    public Integer stackLimit;

    @SerializedName("max_processes_and_or_threads")
    @Expose
    public Integer maxProcessesAndOrThreads;

    @SerializedName("enable_per_process_and_thread_time_limit")
    @Expose
    public Boolean enablePerProcessAndThreadTimeLimit;

    @SerializedName("enable_per_process_and_thread_memory_limit")
    @Expose
    public Boolean enablePerProcessAndThreadMemoryLimit;

    @SerializedName("max_file_size")
    @Expose
    public Integer maxFileSize;

    @SerializedName("number_of_runs")
    @Expose
    public Integer numberOfRuns;

    /**
     *    Getter Methods
     * */

    public String getSourceCode() {
        return sourceCode;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public String getStdin() {
        return stdin;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public Double getCpuTimeLimit() {
        return cpuTimeLimit;
    }

    public Double getCpuExtraTime() {
        return cpuExtraTime;
    }

    public Double getWallTimeLimit() {
        return wallTimeLimit;
    }

    public Integer getMemoryLimit() {
        return memoryLimit;
    }

    public Integer getStackLimit() {
        return stackLimit;
    }

    public Integer getMaxProcessesAndOrThreads() {
        return maxProcessesAndOrThreads;
    }

    public Boolean getEnablePerProcessAndThreadTimeLimit() {
        return enablePerProcessAndThreadTimeLimit;
    }

    public Boolean getEnablePerProcessAndThreadMemoryLimit() {
        return enablePerProcessAndThreadMemoryLimit;
    }

    public Integer getMaxFileSize() {
        return maxFileSize;
    }

    public Integer getNumberOfRuns() {
        return numberOfRuns;
    }

    /**
     *    Builder Methods
     * */

    public CompileRequestDO setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
        return this;
    }

    public CompileRequestDO setLanguageId(Integer languageId) {
        this.languageId = languageId;
        return this;
    }

    public CompileRequestDO setStdin(String stdin) {
        this.stdin = stdin;
        return this;
    }

    public CompileRequestDO setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
        return this;
    }

    public CompileRequestDO setCpuTimeLimit(Double cpuTimeLimit) {
        this.cpuTimeLimit = cpuTimeLimit;
        return this;
    }

    public CompileRequestDO setCpuExtraTime(Double cpuExtraTime) {
        this.cpuExtraTime = cpuExtraTime;
        return this;
    }

    public CompileRequestDO setWallTimeLimit(Double wallTimeLimit) {
        this.wallTimeLimit = wallTimeLimit;
        return this;
    }

    public CompileRequestDO setMemoryLimit(Integer memoryLimit) {
        this.memoryLimit = memoryLimit;
        return this;
    }

    public CompileRequestDO setStackLimit(Integer stackLimit) {
        this.stackLimit = stackLimit;
        return this;
    }

    public CompileRequestDO setMaxProcessesAndOrThreads(Integer maxProcessesAndOrThreads) {
        this.maxProcessesAndOrThreads = maxProcessesAndOrThreads;
        return this;
    }

    public CompileRequestDO setEnablePerProcessAndThreadTimeLimit(Boolean enablePerProcessAndThreadTimeLimit) {
        this.enablePerProcessAndThreadTimeLimit = enablePerProcessAndThreadTimeLimit;
        return this;
    }

    public CompileRequestDO setEnablePerProcessAndThreadMemoryLimit(Boolean enablePerProcessAndThreadMemoryLimit) {
        this.enablePerProcessAndThreadMemoryLimit = enablePerProcessAndThreadMemoryLimit;
        return this;
    }

    public CompileRequestDO setMaxFileSize(Integer maxFileSize) {
        this.maxFileSize = maxFileSize;
        return this;
    }

    public CompileRequestDO setNumberOfRuns(Integer numberOfRuns) {
        this.numberOfRuns = numberOfRuns;
        return this;
    }

    @Override
    public String toString() {

        ConcurrentHashMap<String, Object> map = getInputPropertyMap();

        return map.toString();
    }

    @NonNull
    public ConcurrentHashMap<String, Object> getInputPropertyMap() {

        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        if (sourceCode != null)
            map.put("sourceCode", sourceCode);

        if (languageId != null)
            map.put("languageId", languageId);

        if (stdin != null)
            map.put("stdin", stdin);

        if (expectedOutput != null) map.put("expectedOutput", expectedOutput);

        if (cpuTimeLimit != null)
            map.put("cpuTimeLimit", cpuTimeLimit);

        if (cpuExtraTime != null)
            map.put("cpuExtraTime", cpuExtraTime);

        if (wallTimeLimit != null)
            map.put("wallTimeLimit", wallTimeLimit);

        if (memoryLimit != null)
            map.put("memoryLimit", memoryLimit);

        if (stackLimit != null)
            map.put("stackLimit", stackLimit);

        if (maxProcessesAndOrThreads != null)
            map.put("maxProcessesAndOrThreads", maxProcessesAndOrThreads);

        if (enablePerProcessAndThreadTimeLimit != null)
            map.put("enablePerProcessAndThreadTimeLimit", enablePerProcessAndThreadTimeLimit);

        if (enablePerProcessAndThreadMemoryLimit != null)
            map.put("enablePerProcessAndThreadMemoryLimit", enablePerProcessAndThreadMemoryLimit);

        if (maxFileSize != null)
            map.put("maxFileSize", maxFileSize);

        if (numberOfRuns != null)
            map.put("numberOfRuns", numberOfRuns);

        return map;
    }

}

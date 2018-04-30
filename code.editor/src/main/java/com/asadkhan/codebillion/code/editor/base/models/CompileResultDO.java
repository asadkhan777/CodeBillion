
package com.asadkhan.codebillion.code.editor.base.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.concurrent.ConcurrentHashMap;

public class CompileResultDO extends CompileRequestDO {

    @SerializedName("stdout")
    @Expose
    public String stdout;

    @SerializedName("stderr")
    @Expose
    public String stderr;

    @SerializedName("compile_output")
    @Expose
    public String compileOutput;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("exit_code")
    @Expose
    public Integer exitCode;

    @SerializedName("exit_signal")
    @Expose
    public Integer exitSignal;

    @SerializedName("status")
    @Expose
    public Status status;

    @SerializedName("created_at")
    @Expose
    public String createdAt;

    @SerializedName("finished_at")
    @Expose
    public String finishedAt;

    @SerializedName("token")
    @Expose
    public String token;

    @SerializedName("time")
    @Expose
    public String time;

    @SerializedName("wall_time")
    @Expose
    public String wallTime;

    @SerializedName("memory")
    @Expose
    public Double memory;


    /**
     *    Getter Methods
     * */

    public String getStdout() {
        return stdout;
    }

    public String getStderr() {
        return stderr;
    }

    public String getCompileOutput() {
        return compileOutput;
    }

    public String getMessage() {
        return message;
    }

    public Integer getExitCode() {
        return exitCode;
    }

    public Integer getExitSignal() {
        return exitSignal;
    }

    public Status getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public String getToken() {
        return token;
    }

    public String getTime() {
        return time;
    }

    public String getWallTime() {
        return wallTime;
    }

    public Double getMemory() {
        return memory;
    }

    /**
     *    Builder Methods
     * */

    public CompileResultDO setStdout(String stdout) {
        this.stdout = stdout;
        return this;
    }

    public CompileResultDO setStderr(String stderr) {
        this.stderr = stderr;
        return this;
    }

    public CompileResultDO setCompileOutput(String compileOutput) {
        this.compileOutput = compileOutput;
        return this;
    }

    public CompileResultDO setMessage(String message) {
        this.message = message;
        return this;
    }

    public CompileResultDO setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
        return this;
    }

    public CompileResultDO setExitSignal(Integer exitSignal) {
        this.exitSignal = exitSignal;
        return this;
    }

    public CompileResultDO setStatus(Status status) {
        this.status = status;
        return this;
    }

    public CompileResultDO setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public CompileResultDO setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }

    public CompileResultDO setToken(String token) {
        this.token = token;
        return this;
    }

    public CompileResultDO setTime(String time) {
        this.time = time;
        return this;
    }

    public CompileResultDO setWallTime(String wallTime) {
        this.wallTime = wallTime;
        return this;
    }

    public CompileResultDO setMemory(Double memory) {
        this.memory = memory;
        return this;
    }

    @Override
    public String toString() {

        ConcurrentHashMap<String, Object> map = getInputPropertyMap();

        if (stdout != null)
            map.put("stdout", stdout);

        if (stderr != null)
            map.put("stderr", stderr);

        if (compileOutput != null)
            map.put("compileOutput", compileOutput);

        if (message != null)
            map.put("message", message);

        if (exitCode != null)
            map.put("exitCode", exitCode);

        if (exitSignal != null)
            map.put("exitSignal", exitSignal);

        if (status != null)
            map.put("status", status);

        if (createdAt != null)
            map.put("createdAt", createdAt);

        if (finishedAt != null)
            map.put("finishedAt", finishedAt);

        if (token != null)
            map.put("token", token);

        if (time != null)
            map.put("time", time);

        if (wallTime != null)
            map.put("wallTime", wallTime);

        if (memory != null)
            map.put("memory", memory);

        return map.toString();
    }

}

package com.asadkhan.codebillion.code.editor.data;

import com.asadkhan.codebillion.code.editor.base.models.CompileRequestDO;
import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;
import com.asadkhan.codebillion.code.editor.base.models.TokenDO;
import com.asadkhan.codebillion.code.editor.base.presenters.Repository;

import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Response;


@Singleton
public interface CompilerRepository extends Repository {

    Observable<Response<TokenDO>> compile(CompileRequestDO compileRequestDO);

    Observable<TokenDO> execute(CompileRequestDO compileRequestDO);

    Observable<Response<TokenDO>> compile(String sourceCode, int languageId);

    Observable<TokenDO> execute(String sourceCode, int languageId);

    Observable<Response<CompileResultDO>> fetchResults(String token);

    Observable<Response<CompileResultDO>> compileAsync(CompileRequestDO requestDO);
}

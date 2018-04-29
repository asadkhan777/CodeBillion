package com.asadkhan.codebillion.code.editor.base.presenters;

public abstract class UseCase<REPOSITORY extends Repository> {

    public REPOSITORY repository;

    public UseCase(REPOSITORY repository) {
        this.repository = repository;
    }
}

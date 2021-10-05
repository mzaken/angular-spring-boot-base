package com.mzaken.springbootangularbase.client.rest;

import com.mzaken.springbootangularbase.db.user.AppUser;

@FunctionalInterface
public interface BusinessLogic<T> {

	public T perform(AppUser currentUser) throws Exception;
}

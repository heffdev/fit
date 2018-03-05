package com.heffdev.fit.service;

import com.heffdev.fit.exception.FitException;

public interface FitService {

	void createHealthCheckPing() throws FitException;

}
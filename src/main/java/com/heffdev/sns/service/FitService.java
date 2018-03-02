package com.heffdev.sns.service;

import com.heffdev.sns.exception.FitException;

public interface FitService {

	void createHealthCheckPing() throws FitException;

}
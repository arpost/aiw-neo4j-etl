package edu.emory.cci.aiw.neo4jetl;

/*
 * #%L
 * AIW Neo4j ETL
 * %%
 * Copyright (C) 2015 Emory University
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

/**
 *
 * @author Andrew Post
 */
public final class CommandFailedException extends Exception {
	private final int exitValue;

	CommandFailedException(int exitValue, String message) {
		super(message);
		this.exitValue = exitValue;
	}
	
	CommandFailedException(int exitValue, String message, Throwable throwable) {
		super(message, throwable);
		this.exitValue = exitValue;
	}
	
	int getExitValue() {
		return this.exitValue;
	}
	
}

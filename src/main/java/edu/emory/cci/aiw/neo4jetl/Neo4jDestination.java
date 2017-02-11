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

import edu.emory.cci.aiw.neo4jetl.config.Configuration;
import java.util.List;
import org.protempa.DataSource;
import org.protempa.KnowledgeSource;
import org.protempa.ProtempaEventListener;
import org.protempa.dest.AbstractDestination;
import org.protempa.dest.QueryResultsHandler;
import org.protempa.dest.QueryResultsHandlerInitException;
import org.protempa.dest.Statistics;
import org.protempa.dest.StatisticsException;
import org.protempa.query.Query;

/**
 * @author hrathod
 */
public class Neo4jDestination extends AbstractDestination {

	private final Configuration configuration;
	private final String id;

	public Neo4jDestination(Configuration configuration) {
		if (configuration == null) {
			throw new IllegalArgumentException("configuration cannot be null");
		}
		this.configuration = configuration;
		this.id = this.configuration.getName();
	}

	@Override
	public String getId() {
		return this.id != null ? this.id : super.getId();
	}
	
	@Override
	public QueryResultsHandler getQueryResultsHandler(Query query, DataSource dataSource, KnowledgeSource knowledgeSource, List<? extends ProtempaEventListener> eventListeners) throws QueryResultsHandlerInitException {
		return new Neo4jQueryResultsHandler(query, dataSource, this.configuration);
	}

	@Override
	public boolean isGetStatisticsSupported() {
		return true;
	}

	@Override
	public Statistics getStatistics() throws StatisticsException {
		return new Neo4jStatistics(this.configuration);
	}
	
	@Override
	public String[] getSupportedPropositionIds(DataSource dataSource, KnowledgeSource knowledgeSource) {
		return this.configuration.getPropositionIds();
	}
}

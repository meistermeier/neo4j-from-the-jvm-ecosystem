/*
 * Copyright (c) 2002-2020 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4j.examples.jvm.helidon.se.reactive.movies;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

/**
 * @author Michael J. Simons
 */
public final class MovieService implements Service {

	private final MovieRepository movieRepository;

	public MovieService(final MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public void update(Routing.Rules rules) {
		rules.get("/api/movies", this::findMoviesHandler);
	}

	private void findMoviesHandler(ServerRequest request, ServerResponse response) {
		var movies = this.movieRepository.findAll();
		response.send(movies, Movie.class);
	}
}
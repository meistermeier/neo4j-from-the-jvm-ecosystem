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
package org.neo4j.examples.jvm.quarkus.ogm.movies;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Value;
import org.neo4j.ogm.session.SessionFactory;

/**
 * @author Michael J. Simons
 */
@ApplicationScoped
public class MovieRepository {

	private final SessionFactory sessionFactory;

	MovieRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Collection<Movie> findAll() {

		return sessionFactory.openSession().loadAll(Movie.class);
/*
		try (var session = driver.session()) {

			var query
				= ""
				  + "MATCH (m:Movie)\n"
				  + "MATCH (m) <- [:DIRECTED] - (d:Person)\n"
				  + "MATCH (m) <- [r:ACTED_IN] - (a:Person)\n"
				  + "RETURN m, collect(DISTINCT d) AS directors, collect(DISTINCT {name:a.name, roles: r.roles}) AS actors\n"
				  + "ORDER BY m.name ASC";

			return session.readTransaction(tx -> tx.run(query).list(r -> {
				var movieNode = r.get("m").asNode();

				var directors = r.get("directors").asList(v -> asPerson(v.asNode()));
				var actors = r.get("actors").asList(v -> new Actor(v.get("name").asString(), v.get("roles").asList(Value::asString)));

				var m = new Movie(movieNode.get("title").asString(), movieNode.get("tagline").asString());
				m.setReleased(movieNode.get("released").asInt());
				m.addDirectors(directors);
				m.addActors(actors);
				return m;
			}));
		}*/
		//return List.of();
	}
}

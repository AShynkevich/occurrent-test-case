/*
 * Copyright 2020 Johan Haleby
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.occurrent.example.bigdecimal;

import org.occurrent.domain.DomainEvent;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class NameApplicationService {

    private final DomainEventStore eventStore;

    public NameApplicationService(DomainEventStore eventStore) {
        this.eventStore = eventStore;
    }

    @PostConstruct
    void init() {
        LocalDateTime now = LocalDateTime.now();
        UUID id = UUID.randomUUID();

        defineName(id, now, "Alex", new BigDecimal("1234567890123456.62"));
    }

    public void defineName(UUID streamId, LocalDateTime time, String name, BigDecimal salary) {
        List<DomainEvent> events = Collections.singletonList(
                new NameDefined(UUID.randomUUID().toString(), time, name, salary));
        eventStore.append(streamId, events);
    }
}
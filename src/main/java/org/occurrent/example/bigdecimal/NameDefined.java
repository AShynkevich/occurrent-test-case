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
import org.occurrent.time.TimeConversion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class NameDefined implements DomainEvent {

    private String eventId;
    private Date timestamp;
    private String name;
    private BigDecimal salary;

    @SuppressWarnings("unused")
    NameDefined() {
    }

    public NameDefined(String eventId, Date timestamp, String name, BigDecimal salary) {
        this.eventId = eventId;
        this.timestamp = timestamp;
        this.name = name;
        this.salary = salary;
    }

    public NameDefined(String eventId, LocalDateTime timestamp, String name, BigDecimal salary) {
        this(eventId, TimeConversion.toDate(timestamp), name, salary);
    }

    @Override
    public String getEventId() {
        return eventId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NameDefined)) return false;
        NameDefined that = (NameDefined) o;
        return Objects.equals(eventId, that.eventId) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(name, that.name) &&
                Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, timestamp, name);
    }

    @Override
    public String toString() {
        return "NameDefined{" +
                "id='" + eventId + '\'' +
                ", timestamp=" + timestamp +
                ", name='" + name + '\'' +
                '}';
    }
}
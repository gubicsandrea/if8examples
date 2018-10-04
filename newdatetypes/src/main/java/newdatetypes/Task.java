package newdatetypes;

import java.time.*;

public class Task {
    private int id;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDate deadline;
    private State state = State.NEW;
    private LocalDateTime started;
    private LocalDateTime finished;

    public Task(int id, LocalDate deadline) {
        if (!deadline.isAfter(created.toLocalDate())) {
            throw new IllegalArgumentException("Deadline must be later than created.");
        }
        this.id = id;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public State getState() {
        return state;
    }

    public LocalDateTime getStarted() {
        return started;
    }

    public LocalDateTime getFinished() {
        return finished;
    }

    public void startTask() {
        if (getState() != State.NEW) {
            throw new IllegalStateException("The task should be new");
        }

        this.state = State.STARTED;
        this.started = LocalDateTime.now();
    }

    public void endTask() {
        if (getState() == State.STARTED) {
            this.state = State.FINISHED;
            this.finished = LocalDateTime.now();
        }
    }

    public Duration getTimeOfWork() {
        if (getStarted() != null && getFinished() != null) {
            return Duration.between(getStarted(), getFinished());
        } else {
            throw new IllegalStateException("No time added");
        }
    }

    public double getWorkPrice(double hourly) {
        if (started.toLocalDate().isEqual(finished.toLocalDate())) {
            return Duration.between(started.toLocalTime(), finished.toLocalTime()).toHours() * hourly;
        }

        Duration lastDay = Duration.between(LocalTime.of(9, 0, 0),
                finished.toLocalTime());
        Duration firstDay = Duration.between(started.toLocalTime(),
                LocalTime.of(17, 0, 0));
        LocalDate start = started.toLocalDate().plusDays(1);

        int days = 0;
        while (!start.isEqual(finished.toLocalDate())) {
            if (start.getDayOfWeek() != DayOfWeek.SATURDAY &&
                    start.getDayOfWeek() != DayOfWeek.SUNDAY) {
                days++;
            }

            start = start.plusDays(1);
        }

        return days * 8 * hourly + firstDay.toHours() * hourly + lastDay.toHours() * hourly;
    }

    public boolean finishedOnTime() {
        if (state == State.FINISHED) {
            return !(finished.toLocalDate().isAfter(deadline));
        } else if (deadline.isBefore(LocalDate.now())) {
            return false;
        }
        throw new IllegalStateException("Cannot decide");
    }
}

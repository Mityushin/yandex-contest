package ru.mityushin.yandex.contest.april2018;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class Task2 {

    private static final String APPOINT = "APPOINT";
    private static final String PRINT = "PRINT";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        SortedSet<Meeting> meetings = new TreeSet<>();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String command = scan.next();
            switch (command) {
                case APPOINT: {

                    String str = scan.nextLine();
                    Meeting newMeeting = Meeting.parse(str);

                    boolean hasConflict = false;
                    for (Meeting meeting : meetings) {
                        if (meeting.hasConflict(newMeeting)) {
                            hasConflict = true;
                        }
                    }
                    if (!hasConflict) {
                        meetings.add(newMeeting);
                        builder.append("OK").append('\n');
                    } else {
                        builder.append("FAIL").append('\n');
                        builder.append(newMeeting.getMembersAsString()).append('\n');
                    }
                    break;
                }
                case PRINT: {
                    int day = scan.nextInt();
                    String member = scan.next();

                    for (Meeting meeting : meetings) {
                        if (meeting.isMeetingDay(day) && meeting.hasMember(member)) {
                            builder.append(meeting).append('\n');
                        }
                    }
                    break;
                }
                default: {
                    throw new UnsupportedOperationException();
                }
            }
        }

        builder.deleteCharAt(builder.length() - 1);
        System.out.print(builder.toString());

        scan.close();

    }

    private static class Meeting implements Comparable {

        private static final String REGEXP = "\\d{2}:\\d{2}";
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
        private static final Pattern PATTERN = Pattern.compile(REGEXP);

        private LocalDateTime start;
        private LocalDateTime finish;

        private int minutesDuration;

        private List<String> members;

        public Meeting(LocalDateTime start, LocalDateTime finish, int minutesDuration, List<String> members) {
            this.start = start;
            this.finish = finish;
            this.minutesDuration = minutesDuration;
            this.members = members;
        }

        public static Meeting parse(String str) {

            try (Scanner scan = new Scanner(str)) {
                int day = scan.nextInt();
                LocalDate meetingDate = LocalDate.ofYearDay(2018, day);

                String time = scan.next(PATTERN);
                LocalTime meetingStartTime = LocalTime.parse(time, FORMATTER);
                LocalDateTime meetingStart = LocalDateTime.of(meetingDate, meetingStartTime);

                int minutesDuration = scan.nextInt();
                LocalTime meetingFinishTime = meetingStartTime.plusMinutes(minutesDuration);
                LocalDateTime meetingFinish = LocalDateTime.of(meetingDate, meetingFinishTime);

                int numberOfMembers = scan.nextInt();
                List<String> members = new ArrayList<>(numberOfMembers);
                for (int i = 0; i < numberOfMembers; i++) {
                    members.add(scan.next());
                }

                return new Meeting(meetingStart, meetingFinish, minutesDuration, members);
            }
        }

        public boolean hasConflict(Meeting meeting) {
            if (finish.compareTo(meeting.getStart()) > 0
                    && meeting.getFinish().compareTo(start) > 0) {
                return true;
            }
            return false;
        }

        public boolean isMeetingDay(int day) {
            return start.getDayOfYear() == day;
        }

        public boolean hasMember(String member) {
            return members.contains(member);
        }

        public String getMembersAsString() {
            StringJoiner joiner = new StringJoiner(" ");
            for (String member : members) {
                joiner.add(member);
            }

            return joiner.toString();
        }

        public LocalDateTime getStart() {
            return start;
        }

        public LocalDateTime getFinish() {
            return finish;
        }

        @Override
        public String toString() {
            return start.format(FORMATTER) +
                    " " + minutesDuration +
                    " " + getMembersAsString();
        }

        @Override
        public int compareTo(Object o) {
            return start.compareTo(((Meeting) o).getStart());
        }
    }

}

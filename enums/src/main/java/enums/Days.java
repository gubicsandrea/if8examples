package enums;

public enum Days {
    MONDAY("hétfő") {
        @Override
        public Days next() {
            return Days.TUESDAY;
        }
    },
    TUESDAY("kedd") {
        @Override
        public Days next() {
            return Days.WEDNESDAY;
        }
    },
    WEDNESDAY("szerda") {
        @Override
        public Days next() {
            return Days.THURSDAY;
        }
    },
    THURSDAY("csütörtök") {
        @Override
        public Days next() {
            return Days.FRIDAY;
        }
    },
    FRIDAY("péntek") {
        @Override
        public Days next() {
            return Days.SATURDAY;
        }
    },
    SATURDAY("szombat") {
        @Override
        public Days next() {
            return Days.SUNDAY;
        }
    },
    SUNDAY("vasárnap") {
        @Override
        public Days next() {
            return Days.MONDAY;
        }
    };

    private String hungarianName;

    private Days(String hungarianName) {
        this.hungarianName = hungarianName;
    }

    public String getHungarianName() {
        return hungarianName;
    }

    public abstract Days next();
}

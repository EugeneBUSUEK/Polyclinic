package ru.rsreu.polyclinic.enums;

public enum BlockedCondition {

    BLOCKED("blocked"),
    UNBLOCKED("unblocked");

    private final String blockedCondition;

    BlockedCondition(String blockedCondition) {
        this.blockedCondition = blockedCondition;
    }

    public String getBlockedCondition() {
        return this.blockedCondition;
    }
}

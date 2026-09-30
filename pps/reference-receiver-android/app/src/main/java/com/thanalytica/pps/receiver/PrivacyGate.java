package com.thanalytica.pps.receiver;

/** Pure policy gate. No device addresses or rotating tokens are retained. */
public final class PrivacyGate {
    public static final String UUID = "7b2f4d10-9a6e-4ce7-8b7f-6d5050530001";
    public static final long QUIET_MS = 5000;
    private boolean latched = true;
    private long lastRestriction = Long.MIN_VALUE;
    public enum Packet { INVALID, RESTRICT, NO_RESTRICTION }
    public static Packet parse(byte[] p) {
        if (p == null || p.length != 8 || p[0] != 1 || p[3] != 0
                || (p[1] & 255) > 3 || (p[2] & 128) != 0) return Packet.INVALID;
        // Conservative test policy: any DENY flag stops this app's complete camera.
        return p[1] == 3 || p[2] != 0 ? Packet.RESTRICT : Packet.NO_RESTRICTION;
    }
    public Packet receive(byte[] p, long now) {
        Packet result = parse(p);
        if (result != Packet.NO_RESTRICTION) {
            lastRestriction = now;
            latched = true;
        }
        return result;
    }
    public void lock() { latched = true; }
    public boolean blocked() { return latched; }
    public boolean release(long now, long scanStarted, boolean scanning) {
        if (!scanning || now - scanStarted < QUIET_MS
                || (lastRestriction != Long.MIN_VALUE && now - lastRestriction < QUIET_MS)) return false;
        latched = false;
        return true;
    }
}

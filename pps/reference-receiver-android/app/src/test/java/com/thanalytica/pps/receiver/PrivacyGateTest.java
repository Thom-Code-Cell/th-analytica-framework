package com.thanalytica.pps.receiver;
import org.junit.Test;
import static org.junit.Assert.*;
public class PrivacyGateTest {
    private byte[] maximum() { return new byte[]{1,3,127,0,1,2,3,4}; }
    @Test public void exactWireFormat() {
        assertEquals(PrivacyGate.Packet.RESTRICT, PrivacyGate.parse(maximum()));
        assertEquals(PrivacyGate.Packet.INVALID, PrivacyGate.parse(new byte[9]));
        byte[] p=maximum(); p[0]=2;
        assertEquals(PrivacyGate.Packet.INVALID, PrivacyGate.parse(p));
        p=maximum(); p[3]=1;
        assertEquals(PrivacyGate.Packet.INVALID, PrivacyGate.parse(p));
        p=maximum(); p[2]=(byte)128;
        assertEquals(PrivacyGate.Packet.INVALID, PrivacyGate.parse(p));
    }
    @Test public void quietPeriodNeverAutomaticallyReleases() {
        PrivacyGate g=new PrivacyGate();
        assertTrue(g.blocked());
        assertFalse(g.release(4999,0,true));
        assertTrue(g.release(5000,0,true));
        g.receive(maximum(),6000);
        assertTrue(g.blocked());
        assertFalse(g.release(10000,0,true));
        assertTrue(g.blocked());
        assertFalse(g.release(12000,0,false));
        assertTrue(g.release(12000,0,true));
    }
    @Test public void weakerSecondSenderCannotReleaseRestriction() {
        PrivacyGate g=new PrivacyGate();
        g.receive(maximum(),1000);
        g.receive(new byte[]{1,0,0,0,0,0,0,0},2000);
        assertTrue(g.blocked());
        assertFalse(g.release(5999,0,true));
    }
    @Test public void malformedPacketLocksAndTokenIsIrrelevant() {
        PrivacyGate g=new PrivacyGate(); g.release(5000,0,true);
        g.receive(new byte[]{1},6000); assertTrue(g.blocked());
        byte[] p=maximum(); p[7]=99;
        assertEquals(PrivacyGate.parse(maximum()),PrivacyGate.parse(p));
    }
}

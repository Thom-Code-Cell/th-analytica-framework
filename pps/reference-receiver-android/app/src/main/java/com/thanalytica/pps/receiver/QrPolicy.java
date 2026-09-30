package com.thanalytica.pps.receiver;
import java.net.URI;
import java.util.*;
/** Strict local PPS 0.1 parser. Never opens URLs or executes policy text. */
public final class QrPolicy {
 public enum Verdict { IGNORE, INVALID, RESTRICT, NO_CAPTURE_RESTRICTION }
 public static Verdict parse(String text) {
  if(text==null || !text.toLowerCase(Locale.ROOT).startsWith("pps:")) return Verdict.IGNORE;
  if(text.length()>2048) return Verdict.INVALID;
  try {
   URI u=new URI(text);
   if(!"pps".equals(u.getScheme()) || !"policy".equals(u.getRawAuthority()) || !"/0.1".equals(u.getRawPath()) || u.getRawFragment()!=null || u.getRawQuery()==null) return Verdict.INVALID;
   Map<String,String> p=new HashMap<>();
   for(String item:u.getRawQuery().split("&",-1)) {
    String[] pair=item.split("=",-1);
    if(pair.length!=2 || p.put(pair[0],pair[1])!=null) return Verdict.INVALID;
   }
   Map<String,Set<String>> allowed=new HashMap<>();
   for(String k:new String[]{"cap","id","prof","train","emotion","cuse","cact","law"}) allowed.put(k,Set.of("deny","allow"));
   allowed.put("safety",Set.of("allow","deny"));
   allowed.put("alert",Set.of("automatic","manual","deny"));
   allowed.put("emergency",Set.of("auto-high-confidence","manual","deny"));
   allowed.put("loc",Set.of("emergency-only","deny"));
   allowed.put("eid",Set.of("emergency-only","deny"));
   allowed.put("ret",Set.of("0"));
   if(!p.keySet().equals(allowed.keySet())) return Verdict.INVALID;
   for(String k:p.keySet()) if(!allowed.get(k).contains(p.get(k))) return Verdict.INVALID;
   return "deny".equals(p.get("cap")) ? Verdict.RESTRICT : Verdict.NO_CAPTURE_RESTRICTION;
  } catch(Exception e) { return Verdict.INVALID; }
 }
}

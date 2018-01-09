package org.yamcs.examples;

import org.yamcs.parameter.ParameterValue;
import org.yamcs.parameter.ParameterValueList;
import org.yamcs.utils.BitBuffer;
import org.yamcs.utils.TimeEncoding;
import org.yamcs.xtce.XtceDb;
import org.yamcs.xtceproc.XtceDbFactory;
import org.yamcs.xtceproc.XtceTmExtractor;

/**
 * Example XTCE telemetry extractor
 *
 */
public class XtceExtractor {
    static final String XTCE_DB_NAME = "UT"; //this has to be the name of the MDB configuration in mdb.yaml
    
    public static void main( String[] args ) {
        TimeEncoding.setUp();
        XtceDb xtcedb = XtceDbFactory.createInstanceByConfig(XTCE_DB_NAME);
        XtceTmExtractor tmExtractor=new XtceTmExtractor(xtcedb);
        
        //instruct the tm extractor to provide all parameters
        tmExtractor.startProvidingAll();
        byte[] p1 = new byte[] {(byte)0xA7, //SyncByte1
                                (byte)0xF3, //SyncByte2
                                (byte)((5<<5)|31), //SubsystemID
                                0x00, 0x00, 0x00, 0x06, //NumberOfDataBytesFollowing
                                0x00, 0x10, 0x02, 0x00, 0x30, 0x04}; // 4 Samples
        long t = TimeEncoding.getWallclockTime();
        
        tmExtractor.processPacket(new BitBuffer(p1), t, t);
        ParameterValueList pvl = tmExtractor.getParameterResult();
        for(ParameterValue pv: pvl) {
            System.out.println(pv.getParameter().getName()+":{ eng: "+pv.getEngValue()+", raw: "+pv.getRawValue()+"}");
        }
        
//        System.out.println( "Got parameters: " +pvl);
    }
}

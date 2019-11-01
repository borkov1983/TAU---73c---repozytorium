package borkowski.domain;
import borkowski.store.TimeStampInterface;

import java.util.Date;

public class TimeStamp implements TimeStampInterface {

    @Override

    public long getTimeNow() {
        return new Date().getTime();
    }
}

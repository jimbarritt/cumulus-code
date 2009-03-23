package org.ixcode.cumulus.feedcloud.spike.time;

import org.ixcode.cumulus.feedcloud.spike.time.convert.*;

public interface UnitOfTime {

    long convert(TimeConverter timeConverter);
}

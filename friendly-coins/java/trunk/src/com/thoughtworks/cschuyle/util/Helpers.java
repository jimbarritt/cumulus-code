package com.thoughtworks.cschuyle.util;

import java.util.Collection;

public class Helpers {
    
    public static String stringJoin( Collection<?> objects, String joiner ) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for( Object o : objects ) {
            if( ! first ) {
                builder.append( joiner );
            } else {
                first = false;
            }
            builder.append( (null == o) ? "null" : o.toString() );
        }
        return builder.toString();
    }

    public static abstract class Foreach {
        private Iterable<?> objs;

        public Foreach( Iterable<?> objs ) {
            this.objs = objs;
        }

        public void apply() {
            for( Object o : objs ) {
                each( o );
            }
        }

        protected abstract void each( Object o );

    }
}

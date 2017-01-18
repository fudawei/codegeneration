package com.ellis.cg.code;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by fudw on 16-12-3.
 */
public enum JavaType {
    INTEGER {
        public String name_() {
            return Integer.class.getSimpleName();
        }

        public String fullName() {
            return Integer.class.getName();
        }

        @Override
        public Boolean needImport() {
            return false;
        }
    },
    LONG {
        public String name_() {
            return Long.class.getSimpleName();
        }

        public String fullName() {
            return Long.class.getName();
        }

        @Override
        public Boolean needImport() {
            return false;
        }
    },
    SHORT {
        public String name_() {
            return Short.class.getSimpleName();
        }

        public String fullName() {
            return Short.class.getName();
        }

        @Override
        public Boolean needImport() {
            return false;
        }
    },
    BYTE {
        public String name_() {
            return Byte.class.getSimpleName();
        }

        public String fullName() {
            return Byte.class.getName();
        }

        @Override
        public Boolean needImport() {
            return false;
        }
    },
    DOUBLE {
        public String name_() {
            return String.class.getSimpleName();
        }

        public String fullName() {
            return Double.class.getName();
        }

        @Override
        public Boolean needImport() {
            return false;
        }
    },
    FLOAT {
        public String name_() {
            return Float.class.getSimpleName();
        }
        public String fullName() {
            return Float.class.getName();
        }

        @Override
        public Boolean needImport() {
            return false;
        }
    },
    STRING {
        public String name_() {
            return String.class.getSimpleName();
        }

        public String fullName() {
        return String.class.getName();
    }

        @Override
        public Boolean needImport() {
            return false;
        }
    },
    BIGDECIMAL {
        public String name_() {
            return BigDecimal.class.getSimpleName();
        }

        public String fullName() {
            return BigDecimal.class.getName();
        }

        @Override
        public Boolean needImport() {
            return true;
        }
    },
    CHARACTER {
        public String name_() {
            return Character.class.getSimpleName();
        }

        public String fullName() {
            return Character.class.getName();
        }

        @Override
        public Boolean needImport() {
            return false;
        }
    },
    BOOLEAN {
        public String name_() {
            return Boolean.class.getSimpleName();
        }

        public String fullName() {
            return Boolean.class.getName();
        }

        @Override
        public Boolean needImport() {
            return false;
        }
    },
    TIME {
        @Override
        public String name_() {
            return Time.class.getSimpleName();
        }

        @Override
        public String fullName() {
            return Time.class.getName();
        }

        @Override
        public Boolean needImport() {
            return true;
        }
    },
    DATE {
        public String name_() {
            return Date.class.getSimpleName();
        }

        public String fullName() {
            return Date.class.getName();
        }

        @Override
        public Boolean needImport() {
            return true;
        }
    },TIMESTAMP {
        public String name_() {
            return Timestamp.class.getSimpleName();
        }

        public String fullName() {
            return Timestamp.class.getName();
        }

        @Override
        public Boolean needImport() {
            return true;
        }
    },BYTE_ARRAY {
        public String name_() {
            return "bypt[]";
        }

        public String fullName() {
            return "bypt[]";
        }

        @Override
        public Boolean needImport() {
            return false;
        }
    },CLOB {
        public String name_() {
            return Clob.class.getSimpleName();
        }

        public String fullName() {
            return Clob.class.getName();
        }

        @Override
        public Boolean needImport() {
            return true;
        }
    },BLOB {
        public String name_() {
            return Blob.class.getSimpleName();
        }

        public String fullName() {
            return Blob.class.getName();
        }

        @Override
        public Boolean needImport() {
            return true;
        }
    };



    public abstract String name_();

    public abstract String fullName();

    public abstract Boolean needImport();
}

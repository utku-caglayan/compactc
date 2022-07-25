package test;

import com.hazelcast.nio.serialization.compact.CompactReader;
import com.hazelcast.nio.serialization.compact.CompactSerializer;
import com.hazelcast.nio.serialization.compact.CompactWriter;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Objects;

public class AllTypes {

    public static final class Serializer implements CompactSerializer<AllTypes> {
        @Nonnull
        @Override
        public AllTypes read(@Nonnull CompactReader reader) {

            boolean mboolean = reader.readBoolean("mboolean", false);
            boolean[] mboolean_array = reader.readArrayOfBoolean("mboolean_array", null);
            byte mbyte = reader.readInt8("mbyte", (byte) 0);
            byte[] mbyte_array = reader.readArrayOfInt8("mbyte_array", null);
            short mshort = reader.readInt16("mshort", (short) 0);
            short[] mshort_array = reader.readArrayOfInt16("mshort_array", null);
            int mint = reader.readInt32("mint", 0);
            int[] mint_array = reader.readArrayOfInt32("mint_array", null);
            long mlong = reader.readInt64("mlong", 0);
            long[] mlong_array = reader.readArrayOfInt64("mlong_array", null);
            float mfloat = reader.readFloat32("mfloat", (float) 0.0);
            float[] mfloat_array = reader.readArrayOfFloat32("mfloat_array", null);
            double mdouble = reader.readFloat64("mdouble", 0.0);
            double[] mdouble_array = reader.readArrayOfFloat64("mdouble_array", null);
            java.lang.String mstring = reader.readString("mstring", null);
            java.lang.String[] mstring_array = reader.readArrayOfString("mstring_array", null);
            java.time.LocalDate mdate = reader.readDate("mdate", null);
            java.time.LocalDate[] mdate_array = reader.readArrayOfDate("mdate_array", null);
            java.time.LocalTime mtime = reader.readTime("mtime", null);
            java.time.LocalTime[] mtime_array = reader.readArrayOfTime("mtime_array", null);
            java.time.LocalDateTime mtimestamp = reader.readTimestamp("mtimestamp", null);
            java.time.LocalDateTime[] mtimestamp_array = reader.readArrayOfTimestamp("mtimestamp_array", null);
            java.time.OffsetDateTime mtimestampWithTimezone = reader.readTimestampWithTimezone("mtimestampWithTimezone", null);
            java.time.OffsetDateTime[] mtimestampWithTimezone_array = reader.readArrayOfTimestampWithTimezone("mtimestampWithTimezone_array", null);
            Boolean mnullableboolean = reader.readNullableBoolean("mnullableboolean", null);
            Boolean[] mnullableboolean_array = reader.readArrayOfNullableBoolean("mnullableboolean_array", null);
            Byte mnullablebyte = reader.readNullableInt8("mnullablebyte", null);
            Byte[] mnullablebyte_array = reader.readArrayOfNullableInt8("mnullablebyte_array", null);
            Short mnullableshort = reader.readNullableInt16("mnullableshort", null);
            Short[] mnullableshort_array = reader.readArrayOfNullableInt16("mnullableshort_array", null);
            Integer mnullableint = reader.readNullableInt32("mnullableint", null);
            Integer[] mnullableint_array = reader.readArrayOfNullableInt32("mnullableint_array", null);
            Long mnullablelong = reader.readNullableInt64("mnullablelong", null);
            Long[] mnullablelong_array = reader.readArrayOfNullableInt64("mnullablelong_array", null);
            Float mnullablefloat = reader.readNullableFloat32("mnullablefloat", null);
            Float[] mnullablefloat_array = reader.readArrayOfNullableFloat32("mnullablefloat_array", null);
            Double mnullabledouble = reader.readNullableFloat64("mnullabledouble", null);
            Double[] mnullabledouble_array = reader.readArrayOfNullableFloat64("mnullabledouble_array", null);
            TypesWithDefaults mcompact = reader.readCompact("mcompact", null);
            TypesWithDefaults[] mcompact_array = reader.readArrayOfCompact("mcompact_array", TypesWithDefaults.class);
            return new AllTypes(mboolean, mboolean_array, mbyte, mbyte_array, mshort, mshort_array, mint, mint_array, mlong, mlong_array, mfloat, mfloat_array, mdouble, mdouble_array, mstring, mstring_array, mdate, mdate_array, mtime, mtime_array, mtimestamp, mtimestamp_array, mtimestampWithTimezone, mtimestampWithTimezone_array, mnullableboolean, mnullableboolean_array, mnullablebyte, mnullablebyte_array, mnullableshort, mnullableshort_array, mnullableint, mnullableint_array, mnullablelong, mnullablelong_array, mnullablefloat, mnullablefloat_array, mnullabledouble, mnullabledouble_array, mcompact, mcompact_array);
        }

        @Override
        public void write(@Nonnull CompactWriter writer, @Nonnull AllTypes object) {

            writer.writeBoolean("mboolean", object.mboolean);
            writer.writeArrayOfBoolean("mboolean_array", object.mboolean_array);
            writer.writeInt8("mbyte", object.mbyte);
            writer.writeArrayOfInt8("mbyte_array", object.mbyte_array);
            writer.writeInt16("mshort", object.mshort);
            writer.writeArrayOfInt16("mshort_array", object.mshort_array);
            writer.writeInt32("mint", object.mint);
            writer.writeArrayOfInt32("mint_array", object.mint_array);
            writer.writeInt64("mlong", object.mlong);
            writer.writeArrayOfInt64("mlong_array", object.mlong_array);
            writer.writeFloat32("mfloat", object.mfloat);
            writer.writeArrayOfFloat32("mfloat_array", object.mfloat_array);
            writer.writeFloat64("mdouble", object.mdouble);
            writer.writeArrayOfFloat64("mdouble_array", object.mdouble_array);
            writer.writeString("mstring", object.mstring);
            writer.writeArrayOfString("mstring_array", object.mstring_array);
            writer.writeDate("mdate", object.mdate);
            writer.writeArrayOfDate("mdate_array", object.mdate_array);
            writer.writeTime("mtime", object.mtime);
            writer.writeArrayOfTime("mtime_array", object.mtime_array);
            writer.writeTimestamp("mtimestamp", object.mtimestamp);
            writer.writeArrayOfTimestamp("mtimestamp_array", object.mtimestamp_array);
            writer.writeTimestampWithTimezone("mtimestampWithTimezone", object.mtimestampWithTimezone);
            writer.writeArrayOfTimestampWithTimezone("mtimestampWithTimezone_array", object.mtimestampWithTimezone_array);
            writer.writeNullableBoolean("mnullableboolean", object.mnullableboolean);
            writer.writeArrayOfNullableBoolean("mnullableboolean_array", object.mnullableboolean_array);
            writer.writeNullableInt8("mnullablebyte", object.mnullablebyte);
            writer.writeArrayOfNullableInt8("mnullablebyte_array", object.mnullablebyte_array);
            writer.writeNullableInt16("mnullableshort", object.mnullableshort);
            writer.writeArrayOfNullableInt16("mnullableshort_array", object.mnullableshort_array);
            writer.writeNullableInt32("mnullableint", object.mnullableint);
            writer.writeArrayOfNullableInt32("mnullableint_array", object.mnullableint_array);
            writer.writeNullableInt64("mnullablelong", object.mnullablelong);
            writer.writeArrayOfNullableInt64("mnullablelong_array", object.mnullablelong_array);
            writer.writeNullableFloat32("mnullablefloat", object.mnullablefloat);
            writer.writeArrayOfNullableFloat32("mnullablefloat_array", object.mnullablefloat_array);
            writer.writeNullableFloat64("mnullabledouble", object.mnullabledouble);
            writer.writeArrayOfNullableFloat64("mnullabledouble_array", object.mnullabledouble_array);
            writer.writeCompact("mcompact", object.mcompact);
            writer.writeArrayOfCompact("mcompact_array", object.mcompact_array);
        }
    };

    public static final CompactSerializer<AllTypes> HZ_COMPACT_SERIALIZER = new Serializer();

    private boolean mboolean = false;
    private boolean[] mboolean_array = null;
    private byte mbyte = 0;
    private byte[] mbyte_array = null;
    private short mshort = 0;
    private short[] mshort_array = null;
    private int mint = 0;
    private int[] mint_array = null;
    private long mlong = 0;
    private long[] mlong_array = null;
    private float mfloat = (float) 0.0;
    private float[] mfloat_array = null;
    private double mdouble = 0.0;
    private double[] mdouble_array = null;
    private java.lang.String mstring = null;
    private java.lang.String[] mstring_array = null;
    private java.time.LocalDate mdate = null;
    private java.time.LocalDate[] mdate_array = null;
    private java.time.LocalTime mtime = null;
    private java.time.LocalTime[] mtime_array = null;
    private java.time.LocalDateTime mtimestamp = null;
    private java.time.LocalDateTime[] mtimestamp_array = null;
    private java.time.OffsetDateTime mtimestampWithTimezone = null;
    private java.time.OffsetDateTime[] mtimestampWithTimezone_array = null;
    private Boolean mnullableboolean = null;
    private Boolean[] mnullableboolean_array = null;
    private Byte mnullablebyte = null;
    private Byte[] mnullablebyte_array = null;
    private Short mnullableshort = null;
    private Short[] mnullableshort_array = null;
    private Integer mnullableint = null;
    private Integer[] mnullableint_array = null;
    private Long mnullablelong = null;
    private Long[] mnullablelong_array = null;
    private Float mnullablefloat = null;
    private Float[] mnullablefloat_array = null;
    private Double mnullabledouble = null;
    private Double[] mnullabledouble_array = null;
    private TypesWithDefaults mcompact = null;
    private TypesWithDefaults[] mcompact_array = null;

    public AllTypes() {
    }

    public AllTypes(boolean mboolean, boolean[] mboolean_array, byte mbyte, byte[] mbyte_array, short mshort, short[] mshort_array, int mint, int[] mint_array, long mlong, long[] mlong_array, float mfloat, float[] mfloat_array, double mdouble, double[] mdouble_array, java.lang.String mstring, java.lang.String[] mstring_array, java.time.LocalDate mdate, java.time.LocalDate[] mdate_array, java.time.LocalTime mtime, java.time.LocalTime[] mtime_array, java.time.LocalDateTime mtimestamp, java.time.LocalDateTime[] mtimestamp_array, java.time.OffsetDateTime mtimestampWithTimezone, java.time.OffsetDateTime[] mtimestampWithTimezone_array, Boolean mnullableboolean, Boolean[] mnullableboolean_array, Byte mnullablebyte, Byte[] mnullablebyte_array, Short mnullableshort, Short[] mnullableshort_array, Integer mnullableint, Integer[] mnullableint_array, Long mnullablelong, Long[] mnullablelong_array, Float mnullablefloat, Float[] mnullablefloat_array, Double mnullabledouble, Double[] mnullabledouble_array, TypesWithDefaults mcompact, TypesWithDefaults[] mcompact_array) {

        this.mboolean = mboolean;
        this.mboolean_array = mboolean_array;
        this.mbyte = mbyte;
        this.mbyte_array = mbyte_array;
        this.mshort = mshort;
        this.mshort_array = mshort_array;
        this.mint = mint;
        this.mint_array = mint_array;
        this.mlong = mlong;
        this.mlong_array = mlong_array;
        this.mfloat = mfloat;
        this.mfloat_array = mfloat_array;
        this.mdouble = mdouble;
        this.mdouble_array = mdouble_array;
        this.mstring = mstring;
        this.mstring_array = mstring_array;
        this.mdate = mdate;
        this.mdate_array = mdate_array;
        this.mtime = mtime;
        this.mtime_array = mtime_array;
        this.mtimestamp = mtimestamp;
        this.mtimestamp_array = mtimestamp_array;
        this.mtimestampWithTimezone = mtimestampWithTimezone;
        this.mtimestampWithTimezone_array = mtimestampWithTimezone_array;
        this.mnullableboolean = mnullableboolean;
        this.mnullableboolean_array = mnullableboolean_array;
        this.mnullablebyte = mnullablebyte;
        this.mnullablebyte_array = mnullablebyte_array;
        this.mnullableshort = mnullableshort;
        this.mnullableshort_array = mnullableshort_array;
        this.mnullableint = mnullableint;
        this.mnullableint_array = mnullableint_array;
        this.mnullablelong = mnullablelong;
        this.mnullablelong_array = mnullablelong_array;
        this.mnullablefloat = mnullablefloat;
        this.mnullablefloat_array = mnullablefloat_array;
        this.mnullabledouble = mnullabledouble;
        this.mnullabledouble_array = mnullabledouble_array;
        this.mcompact = mcompact;
        this.mcompact_array = mcompact_array;
    }

    public boolean getMboolean() {
        return mboolean;
    }

    public boolean[] getMboolean_array() {
        return mboolean_array;
    }

    public byte getMbyte() {
        return mbyte;
    }

    public byte[] getMbyte_array() {
        return mbyte_array;
    }

    public short getMshort() {
        return mshort;
    }

    public short[] getMshort_array() {
        return mshort_array;
    }

    public int getMint() {
        return mint;
    }

    public int[] getMint_array() {
        return mint_array;
    }

    public long getMlong() {
        return mlong;
    }

    public long[] getMlong_array() {
        return mlong_array;
    }

    public float getMfloat() {
        return mfloat;
    }

    public float[] getMfloat_array() {
        return mfloat_array;
    }

    public double getMdouble() {
        return mdouble;
    }

    public double[] getMdouble_array() {
        return mdouble_array;
    }

    public java.lang.String getMstring() {
        return mstring;
    }

    public java.lang.String[] getMstring_array() {
        return mstring_array;
    }

    public java.time.LocalDate getMdate() {
        return mdate;
    }

    public java.time.LocalDate[] getMdate_array() {
        return mdate_array;
    }

    public java.time.LocalTime getMtime() {
        return mtime;
    }

    public java.time.LocalTime[] getMtime_array() {
        return mtime_array;
    }

    public java.time.LocalDateTime getMtimestamp() {
        return mtimestamp;
    }

    public java.time.LocalDateTime[] getMtimestamp_array() {
        return mtimestamp_array;
    }

    public java.time.OffsetDateTime getMtimestampWithTimezone() {
        return mtimestampWithTimezone;
    }

    public java.time.OffsetDateTime[] getMtimestampWithTimezone_array() {
        return mtimestampWithTimezone_array;
    }

    public Boolean getMnullableboolean() {
        return mnullableboolean;
    }

    public Boolean[] getMnullableboolean_array() {
        return mnullableboolean_array;
    }

    public Byte getMnullablebyte() {
        return mnullablebyte;
    }

    public Byte[] getMnullablebyte_array() {
        return mnullablebyte_array;
    }

    public Short getMnullableshort() {
        return mnullableshort;
    }

    public Short[] getMnullableshort_array() {
        return mnullableshort_array;
    }

    public Integer getMnullableint() {
        return mnullableint;
    }

    public Integer[] getMnullableint_array() {
        return mnullableint_array;
    }

    public Long getMnullablelong() {
        return mnullablelong;
    }

    public Long[] getMnullablelong_array() {
        return mnullablelong_array;
    }

    public Float getMnullablefloat() {
        return mnullablefloat;
    }

    public Float[] getMnullablefloat_array() {
        return mnullablefloat_array;
    }

    public Double getMnullabledouble() {
        return mnullabledouble;
    }

    public Double[] getMnullabledouble_array() {
        return mnullabledouble_array;
    }

    public TypesWithDefaults getMcompact() {
        return mcompact;
    }

    public TypesWithDefaults[] getMcompact_array() {
        return mcompact_array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllTypes that = (AllTypes) o;
        if (mboolean != that.mboolean) return false;
        if (!Arrays.equals(mboolean_array, that.mboolean_array)) return false;
        if (mbyte != that.mbyte) return false;
        if (!Arrays.equals(mbyte_array, that.mbyte_array)) return false;
        if (mshort != that.mshort) return false;
        if (!Arrays.equals(mshort_array, that.mshort_array)) return false;
        if (mint != that.mint) return false;
        if (!Arrays.equals(mint_array, that.mint_array)) return false;
        if (mlong != that.mlong) return false;
        if (!Arrays.equals(mlong_array, that.mlong_array)) return false;
        if (Float.compare(mfloat, that.mfloat) != 0) return false;
        if (!Arrays.equals(mfloat_array, that.mfloat_array)) return false;
        if (Double.compare(mdouble, that.mdouble) != 0) return false;
        if (!Arrays.equals(mdouble_array, that.mdouble_array)) return false;
        if (!Objects.equals(mstring, that.mstring)) return false;
        if (!Arrays.equals(mstring_array, that.mstring_array)) return false;
        if (!Objects.equals(mdate, that.mdate)) return false;
        if (!Arrays.equals(mdate_array, that.mdate_array)) return false;
        if (!Objects.equals(mtime, that.mtime)) return false;
        if (!Arrays.equals(mtime_array, that.mtime_array)) return false;
        if (!Objects.equals(mtimestamp, that.mtimestamp)) return false;
        if (!Arrays.equals(mtimestamp_array, that.mtimestamp_array)) return false;
        if (!Objects.equals(mtimestampWithTimezone, that.mtimestampWithTimezone)) return false;
        if (!Arrays.equals(mtimestampWithTimezone_array, that.mtimestampWithTimezone_array)) return false;
        if (!Objects.equals(mnullableboolean, that.mnullableboolean)) return false;
        if (!Arrays.equals(mnullableboolean_array, that.mnullableboolean_array)) return false;
        if (!Objects.equals(mnullablebyte, that.mnullablebyte)) return false;
        if (!Arrays.equals(mnullablebyte_array, that.mnullablebyte_array)) return false;
        if (!Objects.equals(mnullableshort, that.mnullableshort)) return false;
        if (!Arrays.equals(mnullableshort_array, that.mnullableshort_array)) return false;
        if (!Objects.equals(mnullableint, that.mnullableint)) return false;
        if (!Arrays.equals(mnullableint_array, that.mnullableint_array)) return false;
        if (!Objects.equals(mnullablelong, that.mnullablelong)) return false;
        if (!Arrays.equals(mnullablelong_array, that.mnullablelong_array)) return false;
        if (!Objects.equals(mnullablefloat, that.mnullablefloat)) return false;
        if (!Arrays.equals(mnullablefloat_array, that.mnullablefloat_array)) return false;
        if (!Objects.equals(mnullabledouble, that.mnullabledouble)) return false;
        if (!Arrays.equals(mnullabledouble_array, that.mnullabledouble_array)) return false;
        if (!Objects.equals(mcompact, that.mcompact)) return false;
        if (!Arrays.equals(mcompact_array, that.mcompact_array)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (mboolean ? 1 : 0);
        result = 31 * result + Arrays.hashCode(mboolean_array);
        result = 31 * result + (int) mbyte;
        result = 31 * result + Arrays.hashCode(mbyte_array);
        result = 31 * result + (int) mshort;
        result = 31 * result + Arrays.hashCode(mshort_array);
        result = 31 * result + (int) mint;
        result = 31 * result + Arrays.hashCode(mint_array);
        result = 31 * result + (int) (mlong ^ (mlong >>> 32));
        result = 31 * result + Arrays.hashCode(mlong_array);
        result = 31 * result + (mfloat != +0.0f ? Float.floatToIntBits(mfloat) : 0);
        result = 31 * result + Arrays.hashCode(mfloat_array);
        long temp;
        temp = Double.doubleToLongBits(mdouble);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(mdouble_array);
        result = 31 * result + Objects.hashCode(mstring);
        result = 31 * result + Arrays.hashCode(mstring_array);
        result = 31 * result + Objects.hashCode(mdate);
        result = 31 * result + Arrays.hashCode(mdate_array);
        result = 31 * result + Objects.hashCode(mtime);
        result = 31 * result + Arrays.hashCode(mtime_array);
        result = 31 * result + Objects.hashCode(mtimestamp);
        result = 31 * result + Arrays.hashCode(mtimestamp_array);
        result = 31 * result + Objects.hashCode(mtimestampWithTimezone);
        result = 31 * result + Arrays.hashCode(mtimestampWithTimezone_array);
        result = 31 * result + Objects.hashCode(mnullableboolean);
        result = 31 * result + Arrays.hashCode(mnullableboolean_array);
        result = 31 * result + Objects.hashCode(mnullablebyte);
        result = 31 * result + Arrays.hashCode(mnullablebyte_array);
        result = 31 * result + Objects.hashCode(mnullableshort);
        result = 31 * result + Arrays.hashCode(mnullableshort_array);
        result = 31 * result + Objects.hashCode(mnullableint);
        result = 31 * result + Arrays.hashCode(mnullableint_array);
        result = 31 * result + Objects.hashCode(mnullablelong);
        result = 31 * result + Arrays.hashCode(mnullablelong_array);
        result = 31 * result + Objects.hashCode(mnullablefloat);
        result = 31 * result + Arrays.hashCode(mnullablefloat_array);
        result = 31 * result + Objects.hashCode(mnullabledouble);
        result = 31 * result + Arrays.hashCode(mnullabledouble_array);
        result = 31 * result + Objects.hashCode(mcompact);
        result = 31 * result + Arrays.hashCode(mcompact_array);

        return result;
    }

    @Override
    public String toString() {
        return "<AllTypes> {"
                + ", + mboolean=" + mboolean
                + ", + mboolean_array=" + Arrays.toString(mboolean_array)
                + ", + mbyte=" + mbyte
                + ", + mbyte_array=" + Arrays.toString(mbyte_array)
                + ", + mshort=" + mshort
                + ", + mshort_array=" + Arrays.toString(mshort_array)
                + ", + mint=" + mint
                + ", + mint_array=" + Arrays.toString(mint_array)
                + ", + mlong=" + mlong
                + ", + mlong_array=" + Arrays.toString(mlong_array)
                + ", + mfloat=" + mfloat
                + ", + mfloat_array=" + Arrays.toString(mfloat_array)
                + ", + mdouble=" + mdouble
                + ", + mdouble_array=" + Arrays.toString(mdouble_array)
                + ", + mstring=" + mstring
                + ", + mstring_array=" + Arrays.toString(mstring_array)
                + ", + mdate=" + mdate
                + ", + mdate_array=" + Arrays.toString(mdate_array)
                + ", + mtime=" + mtime
                + ", + mtime_array=" + Arrays.toString(mtime_array)
                + ", + mtimestamp=" + mtimestamp
                + ", + mtimestamp_array=" + Arrays.toString(mtimestamp_array)
                + ", + mtimestampWithTimezone=" + mtimestampWithTimezone
                + ", + mtimestampWithTimezone_array=" + Arrays.toString(mtimestampWithTimezone_array)
                + ", + mnullableboolean=" + mnullableboolean
                + ", + mnullableboolean_array=" + Arrays.toString(mnullableboolean_array)
                + ", + mnullablebyte=" + mnullablebyte
                + ", + mnullablebyte_array=" + Arrays.toString(mnullablebyte_array)
                + ", + mnullableshort=" + mnullableshort
                + ", + mnullableshort_array=" + Arrays.toString(mnullableshort_array)
                + ", + mnullableint=" + mnullableint
                + ", + mnullableint_array=" + Arrays.toString(mnullableint_array)
                + ", + mnullablelong=" + mnullablelong
                + ", + mnullablelong_array=" + Arrays.toString(mnullablelong_array)
                + ", + mnullablefloat=" + mnullablefloat
                + ", + mnullablefloat_array=" + Arrays.toString(mnullablefloat_array)
                + ", + mnullabledouble=" + mnullabledouble
                + ", + mnullabledouble_array=" + Arrays.toString(mnullabledouble_array)
                + ", + mcompact=" + mcompact
                + ", + mcompact_array=" + Arrays.toString(mcompact_array)
                + '}';
    }

}
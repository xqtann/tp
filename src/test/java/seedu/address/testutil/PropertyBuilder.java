package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Apartment;
import seedu.address.model.person.Bto;
import seedu.address.model.person.Condo;
import seedu.address.model.person.Hdb;
import seedu.address.model.person.HousingType;
import seedu.address.model.person.OtherProperty;
import seedu.address.model.person.PostalCode;
import seedu.address.model.person.Price;
import seedu.address.model.person.Property;
import seedu.address.model.person.UnitNumber;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Property objects.
 */
public class PropertyBuilder {

    public static final String DEFAULT_POSTAL_CODE = "123456";
    public static final String DEFAULT_UNIT_NUMBER = "10-01";
    public static final String DEFAULT_PRICE = "1500000";

    private PostalCode postalCode;
    private UnitNumber unitNumber;
    private Price price;
    private HousingType housingType;
    private Set<Tag> tags;

    /**
     * Creates a {@code PropertyBuilder} with the default details.
     */
    public PropertyBuilder() {
        postalCode = new PostalCode(DEFAULT_POSTAL_CODE);
        unitNumber = new UnitNumber(DEFAULT_UNIT_NUMBER);
        price = new Price(DEFAULT_PRICE);
        housingType = HousingType.HDB;
        tags = new HashSet<>();
    }

    /**
     * Sets the {@code PostalCode} of the {@code Property} that we are building.
     */
    public PropertyBuilder withPostalCode(String postalCode) {
        this.postalCode = new PostalCode(postalCode);
        return this;
    }

    /**
     * Sets the {@code UnitNumber} of the {@code Property} that we are building.
     */
    public PropertyBuilder withUnitNumber(String unitNumber) {
        this.unitNumber = new UnitNumber(unitNumber);
        return this;
    }

    /**
     * Sets the {@code Price} of the {@code Property} that we are building.
     */
    public PropertyBuilder withPrice(String price) {
        this.price = new Price(price);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Property} that we are building.
     */
    public PropertyBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code HousingType} of the {@code Property} that we are building.
     */
    public PropertyBuilder withHousingType(String housingType) {
        this.housingType = HousingType.getHousingType(housingType);
        return this;
    }

    /**
     * Builds the property.
     */
    public Property build() {
        switch (housingType) {
        case HDB:
            return new Hdb(postalCode, unitNumber, price, tags);
        case BTO:
            return new Bto(postalCode, unitNumber, price, tags);
        case CONDO:
            return new Condo(postalCode, unitNumber, price, tags);
        case APARTMENT:
            return new Apartment(postalCode, unitNumber, price, tags);
        case OTHERS:
            return new OtherProperty(postalCode, unitNumber, price, tags);
        default:
            return new Property(postalCode, unitNumber, price, tags) {};
        }
    }
}

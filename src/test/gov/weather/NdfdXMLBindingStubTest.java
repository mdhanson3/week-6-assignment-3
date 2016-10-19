package gov.weather;

import org.junit.Test;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.*;

/**
 * Created by student on 10/18/16.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        // create JAXB context and initializing Marshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


        String result = binding.latLonListZipCode("53711");

        DwmlType latLongObject = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(result));

        String latLonList = latLongObject.getLatLonList();

        assertEquals("Results did not match excpected value", "43.0798,-89.3875", latLonList);
    }

}
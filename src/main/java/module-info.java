module be.webtechie.piheaders {
    requires com.fasterxml.jackson.annotation;

    opens com.pi4j.boardinfo.util;

    exports com.pi4j.boardinfo;
    exports com.pi4j.boardinfo.definition;
    exports com.pi4j.boardinfo.pin;
    exports com.pi4j.boardinfo.util;
    exports com.pi4j.boardinfo.model;
}
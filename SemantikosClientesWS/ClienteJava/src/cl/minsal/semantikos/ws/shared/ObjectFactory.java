
package cl.minsal.semantikos.ws.shared;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cl.minsal.semantikos.ws.shared package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PeticionCodificacionDeNuevoTermino_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "peticionCodificacionDeNuevoTermino");
    private final static QName _Objetivo_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "objetivo");
    private final static QName _Usuario_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "usuario");
    private final static QName _TablaAuxiliar_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "tablaAuxiliar");
    private final static QName _IndirectCrossmap_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "indirectCrossmap");
    private final static QName _ColumnaTablaAuxiliar_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "columnaTablaAuxiliar");
    private final static QName _Categoria_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "categoria");
    private final static QName _DefinicionRelacion_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "definicionRelacion");
    private final static QName _IncrementarContadorDescripcionConsumidaResponse_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "incrementarContadorDescripcionConsumidaResponse");
    private final static QName _IllegalInputFault_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "IllegalInputFault");
    private final static QName _DefinicionObjetivo_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "definicionObjetivo");
    private final static QName _CodificacionDeNuevoTerminoResponse_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "codificacionDeNuevoTerminoResponse");
    private final static QName _CodificacionDeNuevoTermino_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "codificacionDeNuevoTermino");
    private final static QName _RelacionSnomedCT_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "relacionSnomedCT");
    private final static QName _DefinicionRelacionAtributo_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "definicionRelacionAtributo");
    private final static QName _Concepto_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "concepto");
    private final static QName _Atributo_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "atributo");
    private final static QName _CrossmapSetMember_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "crossmapSetMember");
    private final static QName _Descripcion_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "descripcion");
    private final static QName _IncrementarContadorDescripcionConsumida_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "incrementarContadorDescripcionConsumida");
    private final static QName _Multiplicidad_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "multiplicidad");
    private final static QName _AtributoRelacion_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "atributoRelacion");
    private final static QName _RefSet_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "refSet");
    private final static QName _Relacion_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "relacion");
    private final static QName _CrossmapSet_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "crossmapSet");
    private final static QName _RespuestaCodificacionDeNuevoTermino_QNAME = new QName("http://service.ws.semantikos.minsal.cl/", "respuestaCodificacionDeNuevoTermino");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cl.minsal.semantikos.ws.shared
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Relacion }
     * 
     */
    public Relacion createRelacion() {
        return new Relacion();
    }

    /**
     * Create an instance of {@link RefSet }
     * 
     */
    public RefSet createRefSet() {
        return new RefSet();
    }

    /**
     * Create an instance of {@link Concepto }
     * 
     */
    public Concepto createConcepto() {
        return new Concepto();
    }

    /**
     * Create an instance of {@link DefinicionRelacion }
     * 
     */
    public DefinicionRelacion createDefinicionRelacion() {
        return new DefinicionRelacion();
    }

    /**
     * Create an instance of {@link Objetivo }
     * 
     */
    public Objetivo createObjetivo() {
        return new Objetivo();
    }

    /**
     * Create an instance of {@link Objetivo.Fields }
     * 
     */
    public Objetivo.Fields createObjetivoFields() {
        return new Objetivo.Fields();
    }

    /**
     * Create an instance of {@link TablaAuxiliar }
     * 
     */
    public TablaAuxiliar createTablaAuxiliar() {
        return new TablaAuxiliar();
    }

    /**
     * Create an instance of {@link PeticionCodificacionDeNuevoTermino }
     * 
     */
    public PeticionCodificacionDeNuevoTermino createPeticionCodificacionDeNuevoTermino() {
        return new PeticionCodificacionDeNuevoTermino();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link IndirectCrossmap }
     * 
     */
    public IndirectCrossmap createIndirectCrossmap() {
        return new IndirectCrossmap();
    }

    /**
     * Create an instance of {@link Categoria }
     * 
     */
    public Categoria createCategoria() {
        return new Categoria();
    }

    /**
     * Create an instance of {@link cl.minsal.semantikos.ws.shared.ColumnaTablaAuxiliar }
     * 
     */
    public cl.minsal.semantikos.ws.shared.ColumnaTablaAuxiliar createColumnaTablaAuxiliar() {
        return new cl.minsal.semantikos.ws.shared.ColumnaTablaAuxiliar();
    }

    /**
     * Create an instance of {@link IllegalInputFault }
     * 
     */
    public IllegalInputFault createIllegalInputFault() {
        return new IllegalInputFault();
    }

    /**
     * Create an instance of {@link IncrementarContadorDescripcionConsumidaResponse }
     * 
     */
    public IncrementarContadorDescripcionConsumidaResponse createIncrementarContadorDescripcionConsumidaResponse() {
        return new IncrementarContadorDescripcionConsumidaResponse();
    }

    /**
     * Create an instance of {@link DefinicionObjetivo }
     * 
     */
    public DefinicionObjetivo createDefinicionObjetivo() {
        return new DefinicionObjetivo();
    }

    /**
     * Create an instance of {@link Atributo }
     * 
     */
    public Atributo createAtributo() {
        return new Atributo();
    }

    /**
     * Create an instance of {@link DefinicionRelacionAtributo }
     * 
     */
    public DefinicionRelacionAtributo createDefinicionRelacionAtributo() {
        return new DefinicionRelacionAtributo();
    }

    /**
     * Create an instance of {@link RelacionSnomedCT }
     * 
     */
    public RelacionSnomedCT createRelacionSnomedCT() {
        return new RelacionSnomedCT();
    }

    /**
     * Create an instance of {@link CodificacionDeNuevoTerminoResponse }
     * 
     */
    public CodificacionDeNuevoTerminoResponse createCodificacionDeNuevoTerminoResponse() {
        return new CodificacionDeNuevoTerminoResponse();
    }

    /**
     * Create an instance of {@link CodificacionDeNuevoTermino }
     * 
     */
    public CodificacionDeNuevoTermino createCodificacionDeNuevoTermino() {
        return new CodificacionDeNuevoTermino();
    }

    /**
     * Create an instance of {@link Descripcion }
     * 
     */
    public Descripcion createDescripcion() {
        return new Descripcion();
    }

    /**
     * Create an instance of {@link IncrementarContadorDescripcionConsumida }
     * 
     */
    public IncrementarContadorDescripcionConsumida createIncrementarContadorDescripcionConsumida() {
        return new IncrementarContadorDescripcionConsumida();
    }

    /**
     * Create an instance of {@link CrossmapSetMember }
     * 
     */
    public CrossmapSetMember createCrossmapSetMember() {
        return new CrossmapSetMember();
    }

    /**
     * Create an instance of {@link AtributoRelacion }
     * 
     */
    public AtributoRelacion createAtributoRelacion() {
        return new AtributoRelacion();
    }

    /**
     * Create an instance of {@link Multiplicidad }
     * 
     */
    public Multiplicidad createMultiplicidad() {
        return new Multiplicidad();
    }

    /**
     * Create an instance of {@link RespuestaCodificacionDeNuevoTermino }
     * 
     */
    public RespuestaCodificacionDeNuevoTermino createRespuestaCodificacionDeNuevoTermino() {
        return new RespuestaCodificacionDeNuevoTermino();
    }

    /**
     * Create an instance of {@link CrossmapSet }
     * 
     */
    public CrossmapSet createCrossmapSet() {
        return new CrossmapSet();
    }

    /**
     * Create an instance of {@link Relacion.Atributos }
     * 
     */
    public Relacion.Atributos createRelacionAtributos() {
        return new Relacion.Atributos();
    }

    /**
     * Create an instance of {@link RefSet.Conceptos }
     * 
     */
    public RefSet.Conceptos createRefSetConceptos() {
        return new RefSet.Conceptos();
    }

    /**
     * Create an instance of {@link Concepto.RefSets }
     * 
     */
    public Concepto.RefSets createConceptoRefSets() {
        return new Concepto.RefSets();
    }

    /**
     * Create an instance of {@link Concepto.Descripciones }
     * 
     */
    public Concepto.Descripciones createConceptoDescripciones() {
        return new Concepto.Descripciones();
    }

    /**
     * Create an instance of {@link Concepto.Atributos }
     * 
     */
    public Concepto.Atributos createConceptoAtributos() {
        return new Concepto.Atributos();
    }

    /**
     * Create an instance of {@link Concepto.Relaciones }
     * 
     */
    public Concepto.Relaciones createConceptoRelaciones() {
        return new Concepto.Relaciones();
    }

    /**
     * Create an instance of {@link Concepto.RelacionesSnomedCT }
     * 
     */
    public Concepto.RelacionesSnomedCT createConceptoRelacionesSnomedCT() {
        return new Concepto.RelacionesSnomedCT();
    }

    /**
     * Create an instance of {@link Concepto.CrossmapsIndirectos }
     * 
     */
    public Concepto.CrossmapsIndirectos createConceptoCrossmapsIndirectos() {
        return new Concepto.CrossmapsIndirectos();
    }

    /**
     * Create an instance of {@link Concepto.CrossmapsDirectos }
     * 
     */
    public Concepto.CrossmapsDirectos createConceptoCrossmapsDirectos() {
        return new Concepto.CrossmapsDirectos();
    }

    /**
     * Create an instance of {@link DefinicionRelacion.DefinicionesAtributoRelacion }
     * 
     */
    public DefinicionRelacion.DefinicionesAtributoRelacion createDefinicionRelacionDefinicionesAtributoRelacion() {
        return new DefinicionRelacion.DefinicionesAtributoRelacion();
    }

    /**
     * Create an instance of {@link Objetivo.Fields.Entry }
     * 
     */
    public Objetivo.Fields.Entry createObjetivoFieldsEntry() {
        return new Objetivo.Fields.Entry();
    }

    /**
     * Create an instance of {@link TablaAuxiliar.ColumnaTablaAuxiliar }
     * 
     */
    public TablaAuxiliar.ColumnaTablaAuxiliar createTablaAuxiliarColumnaTablaAuxiliar() {
        return new TablaAuxiliar.ColumnaTablaAuxiliar();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PeticionCodificacionDeNuevoTermino }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "peticionCodificacionDeNuevoTermino")
    public JAXBElement<PeticionCodificacionDeNuevoTermino> createPeticionCodificacionDeNuevoTermino(PeticionCodificacionDeNuevoTermino value) {
        return new JAXBElement<PeticionCodificacionDeNuevoTermino>(_PeticionCodificacionDeNuevoTermino_QNAME, PeticionCodificacionDeNuevoTermino.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Objetivo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "objetivo")
    public JAXBElement<Objetivo> createObjetivo(Objetivo value) {
        return new JAXBElement<Objetivo>(_Objetivo_QNAME, Objetivo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Usuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "usuario")
    public JAXBElement<Usuario> createUsuario(Usuario value) {
        return new JAXBElement<Usuario>(_Usuario_QNAME, Usuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TablaAuxiliar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "tablaAuxiliar")
    public JAXBElement<TablaAuxiliar> createTablaAuxiliar(TablaAuxiliar value) {
        return new JAXBElement<TablaAuxiliar>(_TablaAuxiliar_QNAME, TablaAuxiliar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndirectCrossmap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "indirectCrossmap")
    public JAXBElement<IndirectCrossmap> createIndirectCrossmap(IndirectCrossmap value) {
        return new JAXBElement<IndirectCrossmap>(_IndirectCrossmap_QNAME, IndirectCrossmap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link cl.minsal.semantikos.ws.shared.ColumnaTablaAuxiliar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "columnaTablaAuxiliar")
    public JAXBElement<cl.minsal.semantikos.ws.shared.ColumnaTablaAuxiliar> createColumnaTablaAuxiliar(cl.minsal.semantikos.ws.shared.ColumnaTablaAuxiliar value) {
        return new JAXBElement<cl.minsal.semantikos.ws.shared.ColumnaTablaAuxiliar>(_ColumnaTablaAuxiliar_QNAME, cl.minsal.semantikos.ws.shared.ColumnaTablaAuxiliar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Categoria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "categoria")
    public JAXBElement<Categoria> createCategoria(Categoria value) {
        return new JAXBElement<Categoria>(_Categoria_QNAME, Categoria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefinicionRelacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "definicionRelacion")
    public JAXBElement<DefinicionRelacion> createDefinicionRelacion(DefinicionRelacion value) {
        return new JAXBElement<DefinicionRelacion>(_DefinicionRelacion_QNAME, DefinicionRelacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncrementarContadorDescripcionConsumidaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "incrementarContadorDescripcionConsumidaResponse")
    public JAXBElement<IncrementarContadorDescripcionConsumidaResponse> createIncrementarContadorDescripcionConsumidaResponse(IncrementarContadorDescripcionConsumidaResponse value) {
        return new JAXBElement<IncrementarContadorDescripcionConsumidaResponse>(_IncrementarContadorDescripcionConsumidaResponse_QNAME, IncrementarContadorDescripcionConsumidaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IllegalInputFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "IllegalInputFault")
    public JAXBElement<IllegalInputFault> createIllegalInputFault(IllegalInputFault value) {
        return new JAXBElement<IllegalInputFault>(_IllegalInputFault_QNAME, IllegalInputFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefinicionObjetivo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "definicionObjetivo")
    public JAXBElement<DefinicionObjetivo> createDefinicionObjetivo(DefinicionObjetivo value) {
        return new JAXBElement<DefinicionObjetivo>(_DefinicionObjetivo_QNAME, DefinicionObjetivo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodificacionDeNuevoTerminoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "codificacionDeNuevoTerminoResponse")
    public JAXBElement<CodificacionDeNuevoTerminoResponse> createCodificacionDeNuevoTerminoResponse(CodificacionDeNuevoTerminoResponse value) {
        return new JAXBElement<CodificacionDeNuevoTerminoResponse>(_CodificacionDeNuevoTerminoResponse_QNAME, CodificacionDeNuevoTerminoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodificacionDeNuevoTermino }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "codificacionDeNuevoTermino")
    public JAXBElement<CodificacionDeNuevoTermino> createCodificacionDeNuevoTermino(CodificacionDeNuevoTermino value) {
        return new JAXBElement<CodificacionDeNuevoTermino>(_CodificacionDeNuevoTermino_QNAME, CodificacionDeNuevoTermino.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelacionSnomedCT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "relacionSnomedCT")
    public JAXBElement<RelacionSnomedCT> createRelacionSnomedCT(RelacionSnomedCT value) {
        return new JAXBElement<RelacionSnomedCT>(_RelacionSnomedCT_QNAME, RelacionSnomedCT.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefinicionRelacionAtributo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "definicionRelacionAtributo")
    public JAXBElement<DefinicionRelacionAtributo> createDefinicionRelacionAtributo(DefinicionRelacionAtributo value) {
        return new JAXBElement<DefinicionRelacionAtributo>(_DefinicionRelacionAtributo_QNAME, DefinicionRelacionAtributo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Concepto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "concepto")
    public JAXBElement<Concepto> createConcepto(Concepto value) {
        return new JAXBElement<Concepto>(_Concepto_QNAME, Concepto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Atributo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "atributo")
    public JAXBElement<Atributo> createAtributo(Atributo value) {
        return new JAXBElement<Atributo>(_Atributo_QNAME, Atributo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrossmapSetMember }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "crossmapSetMember")
    public JAXBElement<CrossmapSetMember> createCrossmapSetMember(CrossmapSetMember value) {
        return new JAXBElement<CrossmapSetMember>(_CrossmapSetMember_QNAME, CrossmapSetMember.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Descripcion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "descripcion")
    public JAXBElement<Descripcion> createDescripcion(Descripcion value) {
        return new JAXBElement<Descripcion>(_Descripcion_QNAME, Descripcion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncrementarContadorDescripcionConsumida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "incrementarContadorDescripcionConsumida")
    public JAXBElement<IncrementarContadorDescripcionConsumida> createIncrementarContadorDescripcionConsumida(IncrementarContadorDescripcionConsumida value) {
        return new JAXBElement<IncrementarContadorDescripcionConsumida>(_IncrementarContadorDescripcionConsumida_QNAME, IncrementarContadorDescripcionConsumida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multiplicidad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "multiplicidad")
    public JAXBElement<Multiplicidad> createMultiplicidad(Multiplicidad value) {
        return new JAXBElement<Multiplicidad>(_Multiplicidad_QNAME, Multiplicidad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AtributoRelacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "atributoRelacion")
    public JAXBElement<AtributoRelacion> createAtributoRelacion(AtributoRelacion value) {
        return new JAXBElement<AtributoRelacion>(_AtributoRelacion_QNAME, AtributoRelacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "refSet")
    public JAXBElement<RefSet> createRefSet(RefSet value) {
        return new JAXBElement<RefSet>(_RefSet_QNAME, RefSet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Relacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "relacion")
    public JAXBElement<Relacion> createRelacion(Relacion value) {
        return new JAXBElement<Relacion>(_Relacion_QNAME, Relacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrossmapSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "crossmapSet")
    public JAXBElement<CrossmapSet> createCrossmapSet(CrossmapSet value) {
        return new JAXBElement<CrossmapSet>(_CrossmapSet_QNAME, CrossmapSet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaCodificacionDeNuevoTermino }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.semantikos.minsal.cl/", name = "respuestaCodificacionDeNuevoTermino")
    public JAXBElement<RespuestaCodificacionDeNuevoTermino> createRespuestaCodificacionDeNuevoTermino(RespuestaCodificacionDeNuevoTermino value) {
        return new JAXBElement<RespuestaCodificacionDeNuevoTermino>(_RespuestaCodificacionDeNuevoTermino_QNAME, RespuestaCodificacionDeNuevoTermino.class, null, value);
    }

}

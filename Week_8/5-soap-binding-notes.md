# SOAP Bindings
---

A WSDL binding describes how the service is bound to a messaging protocol, particularly the SOAP messaging protocol. A WSDL SOAP binding can be either a Remote Procedure Call (RPC) style binding or a document style binding. A SOAP binding can also have an encoded use or a literal use. This gives four style/use models:

- RPC/encoded
- RPC/literal.
- Document/encoded (not used in practice).
- Document/literal.

---
## Document vs RPC

WSDL distinguishes between two message styles: document and RPC. The message style affects the contents of the SOAP Body:

- **Document style**: 
  - The SOAP Body contains one or more child elements called parts. There are no SOAP formatting rules for what the body contains; it contains whatever the sender and the receiver agrees upon.

- **RPC style**: 
  - RPC implies that SOAP body contains an element with the name of the method or operation being invoked. This element in turn contains an element for each parameter of that method/operation.

---
## Encoding vs Literal

For applications that use serialization/deserialization to abstract away the data wire format, there is one more choice to be made: the serialization format. There are two popular serialization formats:

- **SOAP Encoding**:
  - SOAP encoding is a set of serialization. The rules specify how objects, structures, arrays, and object graphs should be serialized. Generally speaking, an application using SOAP encoding is focused on remote procedure calls and will likely use RPC message style. When SOAP encoding is used, the SOAP message contains data type information within the SOAP message. This makes serialization (data translation) easier since the data type of each parameter is denoted with the parameter.

- **Literal**:
  - Data is serialized according to a schema. In practice, this schema is usually expressed using W3C XML Schema. The SOAP message does not directly contain any data type information, just a reference (namespace) to the schema that is used. To perform proper serialization (data translation) both, the sender and the receiver, must know the schema and must use the same rules for translating data.

### References

[Literal vs. Encoded, RPC- vs. Document-Style](https://www.ibm.com/support/knowledgecenter/en/SSB27H_6.2.0/fa2ws_ovw_soap_syntax_lit.html)
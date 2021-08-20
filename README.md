# cayenne-spring-boot-oracle-example
Apache Cayenne ORM with Spring Boot 2

https://cayenne.apache.org/

# View the images in /tutorial
1. Download Apache Cayenne Modeler version 4.1.B2 and execute Cayenne Modeler;
2. In "Tools/Edit Preferences", configure DataSources Connections and add in ClassPath the resources path of project java and the driver ojdbc;
3. Create a project and right click to add a datanode;
4. With datanode selectioned, click on nav "DB Import" and configure a connection, after that, add a Schema and click in "Run Import".

### Examples:

``` java
///
/// Hibernate
/// SELECT * FROM Perfis WHERE ChavePerfil IN (...)
///
chaves =  chaves.stream().distinct().collect(Collectors.toList());

final PerfisEntity example = new PerfisEntity();
example.setChavePerfil("0");
Example customerExample = Example.create(example).excludeZeroes();

Session session = this.getSessionFactory().getCurrentSession();

Criteria criteria = session.createCriteria(PerfisEntity.class).add(customerExample);
criteria.add(Restrictions.in("chavePerfil", chaves)); /// Query unsafe

return criteria.list();

///
/// Cayenne
/// SELECT * FROM Perfis WHERE ChavePerfil IN (...)
///

ObjectContext context = new MinhaContaDataSource().getContext();

List<Perfis> perfis = ObjectSelect.query(Perfis.class)
        .where(Perfis.CHAVE_PERFIL.in(chaves))
        .select(context);
        
return perfis;
```

```java
///
/// Hibernate
/// SELECT * FROM VinculoEcUsuario WHERE CodEc = X AND DataDesativacao IS NOT NULL ORDER BY DataModificacao DESC
///

EstabelecimentoUsuarioEntity entity = new EstabelecimentoUsuarioEntity();
entity.setCodEc(codEc);
Example customerExample = Example.create(entity).excludeZeroes();

Session session = this.getSessionFactory().getCurrentSession();
Criteria criteria = session.createCriteria(EstabelecimentoUsuarioEntity.class).add(customerExample);

Disjunction disjunction = Restrictions.disjunction();
disjunction.add(Restrictions.isNull("dataDesativacao"));

criteria.add(disjunction);
criteria.addOrder(Order.desc("dataModificacao"));

List result = criteria.list();

///
/// Cayenne
/// SELECT * FROM VinculoEcUsuario WHERE CodEc = X AND DataDesativacao IS NOT NULL ORDER BY DataModificacao DESC
///
ObjectContext context = new MinhaContaDataSource().getContext();

List<VinculoEcUsuario> estabelecimentosUsuario = ObjectSelect.query(VinculoEcUsuario.class)
        .where(VinculoEcUsuario.COD_EC.eq(codEc))
        .and(VinculoEcUsuario.DATA_DESATIVACAO.isNull())
        .orderBy(VinculoEcUsuario.DATA_MODIFICACAO.desc())
        .select(context);
        
return estabelecimentosUsuario;
```

### Main advantages:
- Query Safes;
- Functions based entirely on SQL;
- CayenneModeler graphical tool for object-relational mapping;
- ROP (Remote Object Persistence) an extra layer for scalable ACID, web services, and database access:
- Hibernate uses POJO, cayenne OO;
- Extremely low learning curve.

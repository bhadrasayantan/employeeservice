package com.example.employeeservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/application.properties")
public class DataSourceConfiguration {
	@Value("${custom.hikaricp.jndi-name}")
	private String jndiName;
	@Value("${custom.hikaricp.hikari.connection-timeout}")
	private Long connectionTimeOut;
	@Value("${custom.hikaricp.hikari.idle-timeout}")
	private Long idleTimeout;
	@Value("${custom.hikaricp.hikari.keepalive-time}")
	private Long keepAliveTime;
	@Value("${custom.hikaricp.hikari.leak-detection-threshold}")
	private Long leakDetectionThreshhold;
	@Value("${custom.hikaricp.hikari.max-lifetime}")
	private Long maxLifeTime;
	@Value("${custom.hikaricp.hikari.maximum-pool-size}")
	private Integer maxPoolSize;
	@Value("${custom.hikaricp.hikari.minimum-idle}")
	private Integer minIdle;
	@Value("${custom.hikaricp.hikari.validation-timeout}")
	private Long validationTimeout;
	@Value("${custom.jpa.generate-ddl}")
	private String generateDdl;
	@Value("${custom.jpa.properties.hibernate.max_fetch_depth}")
	private String maxFetchDepth;
	@Value("${custom.jpa.properties.hibernate.jdbc.fetch_size}")
	private String jdbcFetchSize;
	@Value("${custom.jpa.properties.hibernate.jdbc.batch_size}")
	private String jdbcBatchSize;
	@Value("${custom.jpa.properties.hibernate.order_updates}")
	private String orderUpdates;
	@Value("${custom.jpa.properties.hibernate.order_inserts}")
	private String orderInserts;
	@Value("${custom.jpa.properties.hibernate.default_schema}")
	private String defaultSchema;
	@Value("${custom.jpa.properties.hibernate.param_null_passing}")
	private String nullProcParam;
	@Value("${custom.jpa.properties.hibernate.format_sql}")
	private String formatSql;
	@Value("${custom.jpa.properties.hibernate.show_sql}")
	private String showSql;
	@Value("${custom.jpa.properties.ddl-auto}")
	private String ddlAuto;
	@Value("${custom.jpa.properties.naming.implicit-strategy}")
	private String implicitNamingStrategy;
	@Value("${custom.jpa.properties.naming.physical-strategy}")
	private String physicalNamingStrategy;
	@Value("${custom.jpa.properties.hibernate.dialect}")
	private String dialect;
	public String getJndiName() {
		return jndiName;
	}
	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}
	public Long getConnectionTimeOut() {
		return connectionTimeOut;
	}
	public void setConnectionTimeOut(Long connectionTimeOut) {
		this.connectionTimeOut = connectionTimeOut;
	}
	public Long getIdleTimeout() {
		return idleTimeout;
	}
	public void setIdleTimeout(Long idleTimeout) {
		this.idleTimeout = idleTimeout;
	}
	public Long getKeepAliveTime() {
		return keepAliveTime;
	}
	public void setKeepAliveTime(Long keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}
	public Long getLeakDetectionThreshhold() {
		return leakDetectionThreshhold;
	}
	public void setLeakDetectionThreshhold(Long leakDetectionThreshhold) {
		this.leakDetectionThreshhold = leakDetectionThreshhold;
	}
	public Long getMaxLifeTime() {
		return maxLifeTime;
	}
	public void setMaxLifeTime(Long maxLifeTime) {
		this.maxLifeTime = maxLifeTime;
	}
	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}
	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}
	public Integer getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}
	public Long getValidationTimeout() {
		return validationTimeout;
	}
	public void setValidationTimeout(Long validationTimeout) {
		this.validationTimeout = validationTimeout;
	}
	public String getGenerateDdl() {
		return generateDdl;
	}
	public void setGenerateDdl(String generateDdl) {
		this.generateDdl = generateDdl;
	}
	public String getMaxFetchDepth() {
		return maxFetchDepth;
	}
	public void setMaxFetchDepth(String maxFetchDepth) {
		this.maxFetchDepth = maxFetchDepth;
	}
	public String getJdbcFetchSize() {
		return jdbcFetchSize;
	}
	public void setJdbcFetchSize(String jdbcFetchSize) {
		this.jdbcFetchSize = jdbcFetchSize;
	}
	public String getJdbcBatchSize() {
		return jdbcBatchSize;
	}
	public void setJdbcBatchSize(String jdbcBatchSize) {
		this.jdbcBatchSize = jdbcBatchSize;
	}
	public String getOrderUpdates() {
		return orderUpdates;
	}
	public void setOrderUpdates(String orderUpdates) {
		this.orderUpdates = orderUpdates;
	}
	public String getOrderInserts() {
		return orderInserts;
	}
	public void setOrderInserts(String orderInserts) {
		this.orderInserts = orderInserts;
	}
	public String getDefaultSchema() {
		return defaultSchema;
	}
	public void setDefaultSchema(String defaultSchema) {
		this.defaultSchema = defaultSchema;
	}
	public String getNullProcParam() {
		return nullProcParam;
	}
	public void setNullProcParam(String nullProcParam) {
		this.nullProcParam = nullProcParam;
	}
	public String getFormatSql() {
		return formatSql;
	}
	public void setFormatSql(String formatSql) {
		this.formatSql = formatSql;
	}
	public String getShowSql() {
		return showSql;
	}
	public void setShowSql(String showSql) {
		this.showSql = showSql;
	}
	public String getDdlAuto() {
		return ddlAuto;
	}
	public void setDdlAuto(String ddlAuto) {
		this.ddlAuto = ddlAuto;
	}
	public String getImplicitNamingStrategy() {
		return implicitNamingStrategy;
	}
	public void setImplicitNamingStrategy(String implicitNamingStrategy) {
		this.implicitNamingStrategy = implicitNamingStrategy;
	}
	public String getPhysicalNamingStrategy() {
		return physicalNamingStrategy;
	}
	public void setPhysicalNamingStrategy(String physicalNamingStrategy) {
		this.physicalNamingStrategy = physicalNamingStrategy;
	}
	public String getDialect() {
		return dialect;
	}
	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
	@Override
	public String toString() {
		return "DataSourceConfiguration [jndiName=" + jndiName + ", connectionTimeOut=" + connectionTimeOut
				+ ", idleTimeout=" + idleTimeout + ", keepAliveTime=" + keepAliveTime + ", leakDetectionThreshhold="
				+ leakDetectionThreshhold + ", maxLifeTime=" + maxLifeTime + ", maxPoolSize=" + maxPoolSize
				+ ", minIdle=" + minIdle + ", validationTimeout=" + validationTimeout + ", generateDdl=" + generateDdl
				+ ", maxFetchDepth=" + maxFetchDepth + ", jdbcFetchSize=" + jdbcFetchSize + ", jdbcBatchSize="
				+ jdbcBatchSize + ", orderUpdates=" + orderUpdates + ", orderInserts=" + orderInserts
				+ ", defaultSchema=" + defaultSchema + ", nullProcParam=" + nullProcParam + ", formatSql=" + formatSql
				+ ", showSql=" + showSql + ", ddlAuto=" + ddlAuto + ", implicitNamingStrategy=" + implicitNamingStrategy
				+ ", physicalNamingStrategy=" + physicalNamingStrategy + "]";
	}
	
	
	
	
}

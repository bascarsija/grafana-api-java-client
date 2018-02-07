/* Licensed under Apache-2.0 */
package com.appnexus.grafana.client.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(fluent = true)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes({
    @Type(value = GraphDashboardPanel.class, name = "graph"),
    @Type(value = AlertListDashboardPanel.class, name = "alertlist")
})
abstract public class DashboardPanel extends FlexibleSchemaComponent {
  private Boolean editable;
  private Integer id;
  private Integer span;
  private String height;
  private String title;
  private String description;
  private List<DashboardPanelLink> links;
  private Type type;

  public enum Type {
    GRAPH("graph"),
    ALERT_LIST("alertlist");
    private final String value;

    Type(String s) {
      value = s;
    }

    @JsonValue
    public String value() {
      return value;
    }
  }
}

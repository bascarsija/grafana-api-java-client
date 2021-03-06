/* Licensed under Apache-2.0 */
package com.appnexus.grafana.client.models;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Accessors(fluent = true)
public class DashboardPanelAlertCondition extends FlexibleSchemaComponent {
  private DashboardPanelAlertConditionEvaluator evaluator;
  private DashboardPanelAlertConditionQuery query;
  private DashboardPanelAlertConditionReducer reducer;
  private DashboardPanelAlertConditionOperator operator;
  private Type type;

  public enum Type {
    QUERY("query");
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

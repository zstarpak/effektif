/*
 * Copyright 2014 Effektif GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.effektif.workflow.impl.conditions;

import com.effektif.workflow.api.condition.Condition;
import com.effektif.workflow.api.condition.LessThan;
import com.effektif.workflow.impl.workflowinstance.ScopeInstanceImpl;


/**
 * @author Tom Baeyens
 */
public class LessThanImpl extends ComparatorImpl {

  @Override
  public Class< ? extends Condition> getApiType() {
    return LessThan.class;
  }

  @Override
  public boolean compare(Object leftValue, Object rightValue, ScopeInstanceImpl scopeInstance) {
    if (leftValue==null && rightValue==null) return true;
    if (leftValue!=null && rightValue==null) return false;
    if (leftValue==null && rightValue!=null) return false;
    if (!(leftValue instanceof Number)
        || !(rightValue instanceof Number) ) {
      return false;
    }
    return ((Number)leftValue).doubleValue() < ((Number)rightValue).doubleValue();
  }
  
  public String getComparatorSymbol() {
    return "<";
  }
}

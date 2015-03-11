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
package com.effektif.workflow.api.workflow;

import org.joda.time.LocalDateTime;

import com.effektif.workflow.api.WorkflowEngine;
import com.effektif.workflow.api.model.UserId;
import com.effektif.workflow.api.model.WorkflowId;
import com.effektif.workflow.api.types.Type;


/** An executable workflow in API format to deploy 
 * it into the {@link WorkflowEngine}.
 * 
 * From this API format, the workflow can be converted 
 * to following other formats:
 * <ul>
 *   <li>JSON java format (maps and lists)</li>
 *   <li>JSON format (String or stream)</li>
 *   <li>BPMN XML</li>
 *   <li>DB format</li>
 * </ul>
 *
 * BPMN XML:
 * <pre>{@code
 * <process id="vacationRequest" name="Vacation request">
 *   <!-- activities -->
 * </process>
 * }</pre>
 *
 * @author Tom Baeyens
 */
public class Workflow extends AbstractWorkflow {
  
  protected String sourceWorkflowId;
  protected LocalDateTime createTime;
  protected UserId creatorId;

  /** refers to the id in the source (or authoring) form of this workflow.
   * @see #sourceWorkflowId(String) */
  public String getSourceWorkflowId() {
    return this.sourceWorkflowId;
  }
  
  /** refers to the id in the source (or authoring) form of this workflow.
   * @see #sourceWorkflowId(String) */
  public void setSourceWorkflowId(String source) {
    this.sourceWorkflowId = source;
  }

  /** refers to the id in the source (or authoring) form of this workflow.
   * Authoring and source mean that there is some file or form that gets edited 
   * and changes.  Then a snapshot of this sourceform gets deployed as an executable workflow.
   * Workflows are authored in some editor.  Either a file editor or the Effektif product editor.
   * The 3 sources where a workflow could be created are:
   * 1) The Java API.  You could deploy a workflow with the same value {@link #sourceWorkflowId(String)} 
   * multiple times.
   * 2) A BPMN-file.  When parsing a BPMN-file, then the sourceWorkflowId is set to the 
   * id attribute of the process element.
   * 3) The Effektif product editor.  In that case, the workflows you see in the tool 
   * are in fact editor workflows.  You'll find the editor workflow id as the sourceWorkflowId 
   * in the deployed processes.*/
  public Workflow sourceWorkflowId(String sourceWorkflowId) {
    this.sourceWorkflowId = sourceWorkflowId;
    return this;
  }
  
  public LocalDateTime getCreateTime() {
    return this.createTime;
  }
  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }
  public Workflow createTime(LocalDateTime createTime) {
    this.createTime = createTime;
    return this;
  }
  
  public UserId getCreatorId() {
    return this.creatorId;
  }
  public void setCreatorId(UserId creatorId) {
    this.creatorId = creatorId;
  }
  public Workflow creatorId(UserId creatorId) {
    this.creatorId = creatorId;
    return this;
  }

  /** add an activity to the workflow */
  @Override
  public Workflow activity(Activity activity) {
    super.activity(activity);
    return this;
  }
  /** add an activity to the workflow */
  @Override
  public Workflow activity(String id, Activity activity) {
    super.activity(id, activity);
    return this;
  }
  /** add a transition to this workflow where the id is specified in the transition */
  @Override
  public Workflow transition(Transition transition) {
    super.transition(transition);
    return this;
  }
  /** add a transition to this workflow and set the given id. */
  @Override
  public Workflow transition(String id, Transition transition) {
    super.transition(id, transition);
    return this;
  }
  /** add a variable to this workflow and set the given id. */
  @Override
  public Workflow variable(String id, Type type) {
    super.variable(id, type);
    return this;
  }
  /** add a timer to this workflow. */
  @Override
  public Workflow timer(Timer timer) {
    super.timer(timer);
    return this;
  }
  /** sets the id of this workflow.
   * The id is not really used during execution. */
  @Override
  public Workflow id(WorkflowId id) {
    super.id(id);
    return this;
  }
  
  @Override
  public Workflow name(String name) {
    super.name(name);
    return this;
  }

  @Override
  public Workflow description(String description) {
    super.description(description);
    return this;
  }

  @Override
  public Workflow property(String key, Object value) {
    super.property(key, value);
    return this;
  }
  
  @Override
  public Workflow propertyOpt(String key, Object value) {
    super.propertyOpt(key, value);
    return this;
  }

  @Override
  public Workflow trigger(Trigger trigger) {
    super.trigger(trigger);
    return this;
  }

  @Override
  public Workflow organizationId(String organizationId) {
    super.organizationId(organizationId);
    return this;
  }

  @Override
  public Workflow variable(Variable variable) {
    super.variable(variable);
    return this;
  }
  
  
}

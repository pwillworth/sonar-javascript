/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011 SonarSource and Eriks Nukis
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.javascript.model.internal.expression;

import com.google.common.collect.Iterators;
import com.sonar.sslr.api.AstNode;
import org.sonar.plugins.javascript.api.symbols.Type;
import org.sonar.plugins.javascript.api.visitors.TreeVisitor;
import org.sonar.javascript.model.internal.JavaScriptTree;
import org.sonar.plugins.javascript.api.tree.Tree;
import org.sonar.plugins.javascript.api.tree.expression.ExpressionTree;
import org.sonar.plugins.javascript.api.tree.expression.TaggedTemplateTree;
import org.sonar.plugins.javascript.api.tree.expression.TemplateLiteralTree;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class TaggedTemplateTreeImpl extends JavaScriptTree implements TaggedTemplateTree {

  private ExpressionTree callee;
  private final TemplateLiteralTree template;

  public TaggedTemplateTreeImpl(TemplateLiteralTreeImpl template) {
    super(Kind.TAGGED_TEMPLATE);
    this.template = template;

    addChildren(template);
  }

  public TaggedTemplateTreeImpl complete(ExpressionTree callee) {
    this.callee = callee;

    prependChildren((AstNode) callee);
    return this;
  }

  @Override
  public ExpressionTree callee() {
    return callee;
  }

  @Override
  public TemplateLiteralTree template() {
    return template;
  }

  @Override
  public Kind getKind() {
    return Kind.TAGGED_TEMPLATE;
  }

  @Override
  public Iterator<Tree> childrenIterator() {
    return Iterators.<Tree>forArray(
      callee,
      template);
  }

  @Override
  public void accept(TreeVisitor visitor) {
    visitor.visitTaggedTemplate(this);
  }

  @Override
  public Set<Type> types() {
    return Collections.emptySet();
  }
}

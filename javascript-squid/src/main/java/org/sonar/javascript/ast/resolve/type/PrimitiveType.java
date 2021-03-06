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
package org.sonar.javascript.ast.resolve.type;

import org.sonar.plugins.javascript.api.symbols.Type;

public enum PrimitiveType implements Type {
  UNKNOWN {
    @Override
    public Kind kind() {
      return Kind.UNKNOWN;
    }
  },
  NUMBER {
    @Override
    public Kind kind() {
      return Kind.NUMBER;
    }
  },
  STRING {
    @Override
    public Kind kind() {
      return Kind.STRING;
    }
  },
  ARRAY {
    @Override
    public Kind kind() {
      return Kind.ARRAY;
    }
  },
  BOOLEAN {
    @Override
    public Kind kind() {
      return Kind.BOOLEAN;
    }
  },
  JQUERY_SELECTOR_OBJECT {
    @Override
    public Kind kind() {
      return Kind.JQUERY_SELECTOR_OBJECT;
    }
  },
  JQUERY_OBJECT {
    @Override
    public Kind kind() {
      return Kind.JQUERY_OBJECT;
    }
  };

  @Override
  public boolean isCallable() {
    return false;
  }

  @Override
  public String toString() {
    return this.kind().name();
  }
}

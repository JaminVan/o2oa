package com.x.cms.assemble.control.jaxrs.document;

import com.x.base.core.project.exception.PromptException;

class ExceptionCategoryIdEmpty extends PromptException {

	private static final long serialVersionUID = 1859164370743532895L;

	ExceptionCategoryIdEmpty() {
		super("栏目信息ID为空，无法进行查询操作。" );
	}
}

package com.x.processplatform.assemble.surface.jaxrs.data;

import com.google.gson.JsonElement;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.processplatform.assemble.surface.Business;
import com.x.processplatform.core.entity.content.Review;

class ActionGetWithJobPath7 extends BaseAction {

	ActionResult<JsonElement> execute(EffectivePerson effectivePerson, String job, String path0, String path1,
			String path2, String path3, String path4, String path5, String path6, String path7) throws Exception {
		try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
			ActionResult<JsonElement> result = new ActionResult<>();
			Business business = new Business(emc);
			if ((!this.manager(business, effectivePerson))
					&& (emc.countEqual(Review.class, Review.person_FIELDNAME,
							effectivePerson.getDistinguishedName()) == 0)
					&& (!this.applicationControl(business, effectivePerson, job))) {
				throw new ExceptionJobAccessDenied(effectivePerson.getName(), job);
			}
			result.setData(this.getData(business, job, path0, path1, path2, path3, path4, path5, path6, path7));
			return result;
		}
	}
}

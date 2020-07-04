package com.app.habilitation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.habilitation.dao.ApplicationDao;
import com.app.habilitation.dao.MenuDao;
import com.app.habilitation.entity.ApplicationEntity;
import com.app.habilitation.entity.MenuEntity;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private ApplicationDao applicationDao;

	private MenuDao menuDao;

	@Autowired
	public ApplicationServiceImpl(ApplicationDao theApplicationDao, MenuDao theMenuDao) {
		applicationDao = theApplicationDao;
		menuDao = theMenuDao;
	}

	@Override
	public List<ApplicationEntity> findAll() {

		return applicationDao.findAll();
	}

	@Override
	public void save(ApplicationEntity app) {

		applicationDao.save(app);

	}

	@Override
	public void deleteById(int theId) {

		applicationDao.deleteById(theId);

	}

	@Override
	public ApplicationEntity findById(int theId) {

		Optional<ApplicationEntity> result = applicationDao.findById(theId);

		ApplicationEntity app = null;

		if (result.isPresent()) {
			app = result.get();
		}

		else {
			throw new RuntimeException("id for application not found" + theId);
		}

		return app;
	}

	@Override
	public void affecterTo(String code, String menu) {

		ApplicationEntity applicationEntity = applicationDao.findByCode(code);
		if (applicationEntity != null) {
			MenuEntity menuEntity = menuDao.findByNom(menu);
			applicationEntity.setMenu(menuEntity);
			menuEntity.getApp().add(applicationEntity);
			menuDao.save(menuEntity);
			applicationDao.save(applicationEntity);
		}

	}

}

package it.company.project.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import it.company.project.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseService<Entity, EntityID, Repository extends JpaRepository<Entity, EntityID>, DTO> {
	
	private final Class<Entity> entityClass;
	private final Repository repository;
	private final Class<DTO> dtoClass;
	protected final ModelMapper modelMapper;
	
	protected BaseService(Class<Entity> entityClass, Repository repository, Class<DTO> dtoClass, ModelMapper modelMapper) {
		this.entityClass = entityClass;
		this.repository = repository;
		this.dtoClass = dtoClass;
		this.modelMapper = modelMapper;
	}
	
	public List<Entity> getAll() {
		return repository.findAll();
	}
	
	public Entity getById(EntityID id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException(entityClass.getSimpleName(), id));
	}
	
	@Transactional
	public Entity save(Entity entity) {
		return repository.saveAndFlush(entity);
	}
	
	@Transactional
	public <S extends Entity> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAllAndFlush(entities);
	}
	
	@Transactional
	public void delete(Entity entity) {
		repository.delete(entity);
	}
	
	@Transactional
	public void deleteAll(Iterable<Entity> entities) {
		repository.deleteAll(entities);
	}
	
	public DTO toDto(Entity entity) {
		return modelMapper.map(entity, dtoClass);
	}
	
	public List<DTO> toDtoList(Collection<Entity> entities) {
		return entities.stream().map(this::toDto).toList();
	}
	
}

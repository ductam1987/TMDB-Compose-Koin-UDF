package com.tmdb.core.model.mapper

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(domain: DomainModel): Entity

    fun mapFromListEntity(entities: List<Entity>): List<DomainModel> = entities.mapTo(
        mutableListOf(),
        ::mapFromEntity,
    )

    fun mapToListEntity(domainModels: List<DomainModel>): List<Entity> = domainModels.mapTo(
        mutableListOf(),
        ::mapToEntity,
    )
}

/**
 * 
 */
package br.com.seg.econotaxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.seg.econotaxi.model.Veiculo;

/**
 * @author bruno
 *
 */
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>, VeiculoRepositoryCustom {

	Veiculo findById(@Param("id") Long id);

}
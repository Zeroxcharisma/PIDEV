<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Produit
 *
 * @ORM\Table(name="produit")
 * @ORM\Entity
 */
class Produit
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_bp", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idBp;

    /**
     * @var string|null
     *
     * @ORM\Column(name="nom_bp", type="string", length=45, nullable=true)
     */
    private $nomBp;

    /**
     * @var string|null
     *
     * @ORM\Column(name="type_bp", type="string", length=45, nullable=true)
     */
    private $typeBp;

    /**
     * @var string|null
     *
     * @ORM\Column(name="desc_bp", type="string", length=100, nullable=true)
     */
    private $descBp;

    /**
     * @var string|null
     *
     * @ORM\Column(name="img_bp", type="blob", length=0, nullable=true)
     */
    private $imgBp;

    /**
     * @var float|null
     *
     * @ORM\Column(name="prix_bp", type="float", precision=10, scale=0, nullable=true)
     */
    private $prixBp;

    public function getIdBp(): ?int
    {
        return $this->idBp;
    }

    public function getNomBp(): ?string
    {
        return $this->nomBp;
    }

    public function setNomBp(?string $nomBp): self
    {
        $this->nomBp = $nomBp;

        return $this;
    }

    public function getTypeBp(): ?string
    {
        return $this->typeBp;
    }

    public function setTypeBp(?string $typeBp): self
    {
        $this->typeBp = $typeBp;

        return $this;
    }

    public function getDescBp(): ?string
    {
        return $this->descBp;
    }

    public function setDescBp(?string $descBp): self
    {
        $this->descBp = $descBp;

        return $this;
    }

    public function getImgBp()
    {
        return $this->imgBp;
    }

    public function setImgBp($imgBp): self
    {
        $this->imgBp = $imgBp;

        return $this;
    }

    public function getPrixBp(): ?float
    {
        return $this->prixBp;
    }

    public function setPrixBp(?float $prixBp): self
    {
        $this->prixBp = $prixBp;

        return $this;
    }


}

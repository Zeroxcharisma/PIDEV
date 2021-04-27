<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Testfitness
 *
 * @ORM\Table(name="testfitness")
 * @ORM\Entity
 */
class Testfitness
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var int
     *
     * @ORM\Column(name="duree", type="integer", nullable=false)
     */
    private $duree;

    /**
     * @var string|null
     *
     * @ORM\Column(name="cours", type="string", length=255, nullable=true)
     */
    private $cours;

    /**
     * @var string
     *
     * @ORM\Column(name="dateE", type="string", length=255, nullable=false)
     */
    private $datee;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getDuree(): ?int
    {
        return $this->duree;
    }

    public function setDuree(int $duree): self
    {
        $this->duree = $duree;

        return $this;
    }

    public function getCours(): ?string
    {
        return $this->cours;
    }

    public function setCours(?string $cours): self
    {
        $this->cours = $cours;

        return $this;
    }

    public function getDatee(): ?string
    {
        return $this->datee;
    }

    public function setDatee(string $datee): self
    {
        $this->datee = $datee;

        return $this;
    }


}
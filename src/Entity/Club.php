<?php

namespace App\Entity;

use App\Repository\ClubRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=ClubRepository::class)
 */
class Club
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $ref;

     /**
     * @ORM\ManyToMany(targetEntity=Student::class,mappedBy="club",cascade={"all"},orphanRemoval=true)
     */
    private $creationDate;
   
    private $students;

    public function __construct()
    {
        $this->creationDate = new ArrayCollection();
    }
    public function getRef(): ?int
    {
        return $this->ref;
    }

    public function getCreationDate(): ?string
    {
        return $this->creationDate;
    }

    public function setCreationDate(string $creationDate): self
    {
        $this->creationDate = $creationDate;

        return $this;
    }

    public function addCreationDate(Student $creationDate): self
    {
        if (!$this->creationDate->contains($creationDate)) {
            $this->creationDate[] = $creationDate;
            $creationDate->addClub($this);
        }

        return $this;
    }

    public function removeCreationDate(Student $creationDate): self
    {
        if ($this->creationDate->removeElement($creationDate)) {
            $creationDate->removeClub($this);
        }

        return $this;
    }
}

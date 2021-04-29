<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Message
 *
 * @ORM\Table(name="message", indexes={@ORM\Index(name="fk_f", columns={"id_rec"})})
 * @ORM\Entity
 */
class Message
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_m", type="integer", nullable=false )
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idM;

    /**
     * @var string
     *
     * @ORM\Column(name="message", type="string", length=255, nullable=false)
     */
 
     private $message;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_rec", type="integer",  nullable=false)
     */
   
     private $idRec;

    public function getIdM(): ?int
    {
        return $this->idM;
    }

    public function getMessage(): ?string
    {
        return $this->message;
    }

    public function setMessage(string $message): self
    {
        $this->message = $message;

        return $this;
    }

    public function getIdRec(): ?int
    {
        return $this->idRec;
    }

    public function setIdRec(?int $idRec): self
    {
        $this->idRec = $idRec;

        return $this;
    }


}
